package com.bok.model;

import java.util.Collection;

import org.apache.ibatis.session.SqlSession;

public class SoloAskManagerDAO {

	// 1 : 1 문의하기 목록 조회
	public Collection<SoloAskManagerVO> getSoloAsk() {

		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Collection<SoloAskManagerVO> list = null;

		try {
			list = conn.selectList("bokMapper.getSoloAskManager");
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		return list;
	}
	
	// 1 : 1 문의하기에서 답변하기 누르면
	public SoloAskManagerVO soloAskDetail(String askNum) {

		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		SoloAskManagerVO sav = null;
		try {
			sav = conn.selectOne("bokMapper.soloAskManagerDetail", askNum);
			
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
		return sav;
	}
	
	// 1 : 1 문의하기 답변하기 버튼 누르면
	public boolean soloAskSend(SoloAskManagerVO vo) {
		
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		boolean result = false;
		try {
			int i = conn.update("bokMapper.soloAskSend", vo);
			if (i == 1) {
				conn.commit();
				result = true;
			}
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
		
		
		return result;
		
	}
}
