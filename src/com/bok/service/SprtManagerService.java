package com.bok.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.DBCP;
import com.bok.model.PagingVO;
import com.bok.model.SprtContentVO;
import com.bok.model.SprtDAO;
import com.bok.model.SprtManagerDAO;
import com.bok.model.SprtPersonVO;

public class SprtManagerService {

	private SprtManagerDAO dao;
	private SprtDAO sprtDao;

	public SprtManagerService() {
		dao = new SprtManagerDAO();
		sprtDao = new SprtDAO();
	}

	//지원금 정보 수정버튼 - 개별 지원금 정보 불러오기
	public SprtPersonVO getSprtPerson(int sprtpNum){
		try(SqlSession session = DBCP.getSqlSessionFactory().openSession()){
			return dao.getSprtPerson(session, sprtpNum);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}

	}

	//지원금 정보 수정버튼 - 상세 지원금 정보 불러오기
	public List<SprtContentVO> getSprtContent(int sprtpNum){
		try(SqlSession session = DBCP.getSqlSessionFactory().openSession()){
			return dao.getSprtContent(session, sprtpNum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//지원금 정보 추가(pulus 버튼) 후 저장 버튼(person & content - insert)
	//특정 지원금 정보 내용 수정하기 누른 후 추가 버튼(insert)
	public boolean setAddSprt(SprtPersonVO sp, List<SprtContentVO> scList) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			boolean result = dao.setAddSprt(session, sp, scList);
			if (result) {
				session.commit();   // 성공했으면 커밋
			} else {
				session.rollback(); // 실패했으면 롤백
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//특정 지원금 정보 내용 수정 수정 버튼(update)
	public boolean setSprt(SprtPersonVO sp, List<SprtContentVO> scList) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			boolean result = dao.setSprt(session, sp, scList);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//지원금 정보 관리의 개별 내용 삭제버튼 누르면 모달창 그 후 진짜 삭제 
	//특정 지원금 정보 전체(person&content) 삭제 버튼(delete)
	public boolean removeSprt(int sprtpNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			boolean result = dao.removeSprt(session, sprtpNum);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//지원금 분류 추가 후 저장 버튼(카테고리 insert)
	public boolean addSprtCategory(String category) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			boolean result = dao.addSprtCategory(session, category);
			if (result) {
				session.commit();
			} else {
				session.rollback();
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//이전 지원금 정보 관리의 카테고리 선택(청년, 대출, 행복주택 등)
	//사용자에게 이전 지원금 정보 제공(종료일 내림차순)
	public List<SprtPersonVO> getBfSprtPerson(int fkSprtNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getBfSprtPerson(session, fkSprtNum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 페이징 지원 - 특정 카테고리의 지원금 리스트 가져오기
	public List<SprtPersonVO> getBfSprtPerson(int fkSprtNum, PagingVO paging) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getPagedBfSprtPersonM(session, fkSprtNum, paging);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 특정 카테고리의 전체 글 수 가져오기
	public int getBfSprtPersonCount(int fkSprtNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return sprtDao.getBfSprtPersonCount(session, fkSprtNum);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
