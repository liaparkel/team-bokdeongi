package com.bok.service;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.CrewDAO;
import com.bok.model.CrewVO;
import com.bok.model.DBCP;

public class CrewService {

	public String loginCrew(CrewVO vo) {
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		
		return new CrewDAO().loginCrew(vo);
	}
}
