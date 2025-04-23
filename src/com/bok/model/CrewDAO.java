package com.bok.model;

import org.apache.ibatis.session.SqlSession;

public class CrewDAO {
	
	// 로그인
	public String loginCrew(CrewVO vo) {
		// NullPointException
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		String name = "";
		try {
			name = conn.selectOne("bokMapper.selectLogin", vo);
			if (name == null) {
				name = "다시 확인하세요.";
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
		return name;
	}
}
