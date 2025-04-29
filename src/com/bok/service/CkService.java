package com.bok.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bok.model.CkContentVO;
import com.bok.model.CkDAO;
import com.bok.model.CkVO;
import com.bok.model.DBCP;

public class CkService {

	private CkDAO dao;

	public CkService() {
		dao = new CkDAO();
	}

	// 체크리스트 카테고리 전체 가져오기
	public List<CkVO> getCkCategory() {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getCkCategory(session);
		} catch (Exception e) {
			return null;
		}
	}

	// 특정 카테고리 이름으로 최신 카테고리 정보 가져오기
	public CkVO getLatestCk(String category) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getLatestCk(session, category);
		} catch (Exception e) {
			return null;
		}
	}

	// 특정 ck_num에 해당하는 체크리스트 항목 가져오기
	public List<CkContentVO> getCkContent(int ckNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getCkContent(session, ckNum);
		} catch (Exception e) {
			return null;
		}
	}

	// 카테고리 추가(categoryName만 받아서 직접 VO 만들고 DB insert)
	public String addCkCategory(String categoryName) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			CkVO vo = new CkVO();
			vo.setCategory(categoryName);
			vo.setTip(null); // tip은 null
			vo.setDate(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

			int result = dao.addckCategory(session, vo);
			session.commit();

			if (result > 0) {
				return categoryName;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	// 카테고리 추가하고 넘어간 화면에서 저장 버튼
	public boolean saveCkContents(int ckNum, String tip, List<CkContentVO> contentList) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {

			// TIP 업데이트
			CkVO ckVo = new CkVO();
			ckVo.setCkNum(ckNum);
			ckVo.setTip(tip);
			int tipResult = dao.setTip(session, ckVo);

			// 제목/본문 insert
			int contentResult = 0;
			for (CkContentVO contentVo : contentList) {
				contentVo.setFkCkNum(ckNum); // fk 설정
				contentResult += dao.addCkContent(session, contentVo);
			}

			// 전체 커밋
			session.commit();

			// TIP 수정과 내용 추가가 둘 다 성공했는지 체크
			return tipResult > 0 && contentResult == contentList.size();
		} catch (Exception e) {
			return false;
		}
	}

	// 카테고리 추가하고 넘어간 화면에서 취소 버튼
	public boolean cancelCkCategory(int ckNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {

			// 체크리스트 내용 먼저 삭제
			dao.deleteCkContents(session, ckNum);

			// 카테고리 삭제
			int result = dao.deleteCk(session, ckNum);

			session.commit();

			return result > 0;
		} catch (Exception e) {
			return false;
		}
	}
}