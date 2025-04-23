package com.bok.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.DBCP;

public class SprtDAO {
	//사용자에게 오늘 기준으로 유효한 지원금 정보(제목, 링크, 요약, 지원 시작일, 지원 종료일)만 카테고리별로 제공
	public List<SprtPersonVO> getSprtPerson(int fkSprtNum) {
		List<SprtPersonVO> list = null;
		SqlSession conn=DBCP.getSqlSessionFactory().openSession();
		list=conn.selectList("bokMapper.getSprtPerson", fkSprtNum);
		conn.close();
		return list;
	}
	
}
