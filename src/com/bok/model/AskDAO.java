package com.bok.model;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class AskDAO {

	public Collection<AskVO> getFaq() {
		
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Collection<AskVO> list = null;
		
		try {
			list = conn.selectList("bokMapper.getAsk");
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
		
		return list;
	}
}
