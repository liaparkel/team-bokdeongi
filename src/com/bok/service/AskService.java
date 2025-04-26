package com.bok.service;

import java.util.Collection;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.AskDAO;
import com.bok.model.AskVO;
import com.bok.model.DBCP;

public class AskService {

	private AskDAO adao;
	
	public AskService() {
		adao = new AskDAO();
	}
	
	public Collection<AskVO> getFaq() {
		
		try {
			SqlSession session = DBCP.getSqlSessionFactory().openSession();
			return adao.getFaq(session);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
