package com.bok.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class SprtDAO {

	//카테고리 가져오기
	public List<SprtInfoVO> getSprtInfo() {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			return conn.selectList("bokMapper.getSprtInfo");
		}catch (Exception e) {
			return null;
		}
	}

	//사용자에게 오늘 기준으로 유효한 지원금 정보 제공
	public List<SprtPersonVO> getSprtPerson(int fkSprtNum) {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			return conn.selectList("bokMapper.getSprtPerson", fkSprtNum);
		}catch (Exception e) {
			return null;
		}
	}

	//제목 아코디언 버튼 클릭 시 개별 내용 제공
	public List<SprtContentVO> getSprtContent(int fkSprtpNum) {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			return conn.selectList("bokMapper.getSprtContent", fkSprtpNum);
		}catch (Exception e) {
			return null;
		}
	}

	//사용자에게 이전 지원금 정보 제공(종료일 내림차순)
	public List<SprtPersonVO> getBfSprtPerson(int fkSprtNum) {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			return conn.selectList("bokMapper.getBfSprtPerson", fkSprtNum);
		}catch (Exception e) {
			return null;
		}
	}

	//사용자에게 카테고리에 해당하는 이전 지원금 정보 제공(종료일 내림차순, Pagination)
	public List<SprtPersonVO> getPagedBfSprtPerson(int fkSprtNum, PagingVO paging) {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			Map<String, Object> params = new HashMap<>();
			params.put("fkSprtNum", fkSprtNum);
			params.put("startRow", paging.getStartRow()+1);
			params.put("endRow", paging.getEndRow());
			return conn.selectList("bokMapper.getPagedBfSprtPerson", params);
		}catch (Exception e) {
			return null;
		}
	}

	//카테고리에 해당하는 전체 게시물 수 조회
	public int getBfSprtPersonCount(int fkSprtNum) {
		try (SqlSession conn = DBCP.getSqlSessionFactory().openSession()) {
			return conn.selectOne("bokMapper.getBfSprtPersonCount", fkSprtNum);
		}catch (Exception e) {
			return 0;
		}
	}

}
