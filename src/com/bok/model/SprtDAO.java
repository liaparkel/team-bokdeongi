package com.bok.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class SprtDAO {

	//카테고리 가져오기
	public List<SprtInfoVO> getSprtInfo(SqlSession session) {
		return session.selectList("bokMapper.getSprtInfo");
	}

	//사용자에게 오늘 기준으로 유효한 지원금 정보 제공
	public List<SprtPersonVO> getSprtPerson(SqlSession session, int fkSprtNum) {
		return session.selectList("bokMapper.getSprtPerson", fkSprtNum);
	}

	//제목 아코디언 버튼 클릭 시 개별 내용 제공
	public List<SprtContentVO> getSprtContent(SqlSession session, int fkSprtpNum) {
		return session.selectList("bokMapper.getSprtContent", fkSprtpNum);
	}

	//사용자에게 이전 지원금 정보 제공(종료일 내림차순)
	public List<SprtPersonVO> getBfSprtPerson(SqlSession session, int fkSprtNum) {
		return session.selectList("bokMapper.getBfSprtPerson", fkSprtNum);
	}

	//사용자에게 카테고리에 해당하는 이전 지원금 정보 제공(종료일 내림차순, Pagination)
	public List<SprtPersonVO> getPagedBfSprtPerson(SqlSession session, int fkSprtNum, PagingVO paging) {
		Map<String, Object> params = new HashMap<>();
		params.put("fkSprtNum", fkSprtNum);
		params.put("startRow", paging.getStartRow()+1);
		params.put("endRow", paging.getEndRow());
		return session.selectList("bokMapper.getPagedBfSprtPerson", params);
	}

	//카테고리에 해당하는 전체 게시물 수 조회
	public int getBfSprtPersonCount(SqlSession session, int fkSprtNum) {
		return session.selectOne("bokMapper.getBfSprtPersonCount", fkSprtNum);
	}

}
