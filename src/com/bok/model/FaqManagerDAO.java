package com.bok.model;

import java.util.Collection;

import org.apache.ibatis.session.SqlSession;

public class FaqManagerDAO {
	
	// 관리자 FAQ 화면 로딩
	public Collection<FaqManagerVO> getFaq() {

		Collection<FaqManagerVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();

		try {
			list = conn.selectList("bokMapper.getFaq");
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		return list;
	}

	// FAQ 항목 수정
	public boolean setFaq(FaqManagerVO vo) {

		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		boolean result = false;
		try {
			int i = conn.update("bokMapper.updateFaq", vo);
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

	// FAQ 항목 추가
	public boolean addFaq(FaqManagerVO vo) {

		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		boolean result = false;
		try {
			int i = conn.insert("bokMapper.addFaq", vo);
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

	public boolean deleteFaq(int faqNum) {

		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		boolean result = false;
		try {
			int i = conn.delete("bokMapper.deleteFaq", faqNum);
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
