package com.bok.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.DBCP;
import com.bok.model.SprtDAO;
import com.bok.model.SprtInfoVO;
import com.bok.model.SprtPersonVO;
import com.bok.model.SprtContentVO;
import com.bok.model.PagingVO;

public class SprtService {

	private SprtDAO dao;

	public SprtService() {
		dao = new SprtDAO();
	}

	// 카테고리 가져오기
	public List<SprtInfoVO> getSprtInfo() {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getSprtInfo(session);
		} catch (Exception e) {
			return null;
		}
	}

	// 사용자에게 오늘 기준으로 유효한 지원금 정보 제공
	public List<SprtPersonVO> getSprtPerson(int fkSprtNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getSprtPerson(session, fkSprtNum);
		} catch (Exception e) {
			return null;
		}
	}

	// 제목 아코디언 버튼 클릭 시 개별 내용 제공
	public List<SprtContentVO> getSprtContent(int fkSprtpNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getSprtContent(session, fkSprtpNum);
		} catch (Exception e) {
			return null;
		}
	}

	// 사용자에게 이전 지원금 정보 제공(종료일 내림차순)
	public List<SprtPersonVO> getBfSprtPerson(int fkSprtNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getBfSprtPerson(session, fkSprtNum);
		} catch (Exception e) {
			return null;
		}
	}

	// 사용자에게 카테고리에 해당하는 이전 지원금 정보 제공(종료일 내림차순, Pagination)
	public List<SprtPersonVO> getPagedBfSprtPerson(int fkSprtNum, PagingVO paging) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getPagedBfSprtPerson(session, fkSprtNum, paging);
		} catch (Exception e) {
			return null;
		}
	}

	// 카테고리에 해당하는 전체 게시물 수 조회
	public int getBfSprtPersonCount(int fkSprtNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getBfSprtPersonCount(session, fkSprtNum);
		} catch (Exception e) {
			return 0;
		}
	}
}
