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
		try {
			SqlSession session = DBCP.getSqlSessionFactory().openSession();
			return sdao.searchEmail(session, email);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addSoloAsk(SoloAskVO vo) {
		try {
			SqlSession session = DBCP.getSqlSessionFactory().openSession();
			return sdao.addSoloAsk(session, vo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public SoloAskVO soloAskDetail(String askNum) {
		try {
			SqlSession session = DBCP.getSqlSessionFactory().openSession();
			return sdao.soloAskDetail(session, askNum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
