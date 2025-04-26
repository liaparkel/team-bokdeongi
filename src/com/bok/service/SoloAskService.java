package com.bok.service;

import java.util.Collection;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.DBCP;
import com.bok.model.SoloAskDAO;
import com.bok.model.SoloAskVO;

public class SoloAskService {

	private SoloAskDAO sdao;

	public SoloAskService() {
		sdao = new SoloAskDAO();
	}

	public Collection<SoloAskVO> getSoloAsk() {
		
		try {
			SqlSession session = DBCP.getSqlSessionFactory().openSession();
			return sdao.getSoloAsk(session);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Collection<SoloAskVO> searchEmail(String email) {

		return new SoloAskDAO().searchEmail(email);
	}

	public boolean addSoloAsk(SoloAskVO vo) {

		return new SoloAskDAO().addSoloAsk(vo);
	}

	public SoloAskVO soloAskDetail(SoloAskVO vo) {

		return new SoloAskDAO().soloAskDetail(vo);
	}
}
