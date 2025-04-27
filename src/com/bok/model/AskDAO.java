package com.bok.model;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class AskDAO {

	public Collection<AskVO> getFaq(SqlSession session) {

		
		return session.selectList("bokMapper.getAsk");
	}
}
