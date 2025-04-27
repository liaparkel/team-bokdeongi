package com.bok.model;

import java.util.Collection;

import org.apache.ibatis.session.SqlSession;

public class SoloAskDAO {

	// 1 : 1 문의하기 목록
	public Collection<SoloAskVO> getSoloAsk(SqlSession session) {

		return session.selectList("bokMapper.getSoloAsk");
	}

	// 1 : 1 문의하기 이메일 검색
	public Collection<SoloAskVO> searchEmail(SqlSession session, String email) {

		return session.selectList("bokMapper.searchEmail", email);
	}

	// 1 : 1 문의하기 글쓰기
	public boolean addSoloAsk(SqlSession session, SoloAskVO vo) {

		boolean result = false;
		if (session.insert("bokMapper.addSoloAsk", vo) == 1) {
			session.commit();
			result = true;
		}

		return result;
	}

	// 1 : 1 문의하기 상세보기
	public SoloAskVO soloAskDetail(SqlSession session, String askNum) {

		return session.selectOne("bokMapper.askDetail", askNum);
	}

	// title, content, answer만 가져오기
	// public String soloAskDetail(SoloAskVO vo) {
	//
	// SqlSession conn = DBCP.getSqlSessionFactory().openSession();
	// SoloAskVO sav = null;
	// try {
	// sav = conn.selectOne("bokMapper.askDetail", vo);
	//
	// } catch (Exception e) {
	// conn.rollback();
	// } finally {
	// conn.close();
	// }
	// return sav.getAskTitle() + sav.getSoloContent() + sav.getSoloAnswer();
	// }
	
}
