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
			e.printStackTrace();
			return null;
		}
	}

	// 특정 카테고리 이름으로 최신 카테고리 정보 가져오기
	public CkVO getLatestCk(String category) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getLatestCk(session, category);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 특정 ck_num에 해당하는 체크리스트 항목 가져오기
	public List<CkContentVO> getCkContent(int ckNum) {
		try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
			return dao.getCkContent(session, ckNum);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//	// 체크리스트 전체 조회
	//    public Collection<CkVO> getCkListInfo(String category) {
	//        return dao.ckListInfo(category);
	//    }
	//
	//    // 체크리스트 최신순 조회
	//    public Collection<CkVO> getCkListRecentInfo(String category) {
	//        return dao.ckListRecentInfo(category);
	//    }
	//
	//    // 체크리스트 제목/내용 수정
	//    public int setCkList(CkVO vo) {
	//        return dao.setCkList(vo);
	//    }
	//
	//    // 체크리스트 추가
	//    public int addCkList(CkVO vo) {
	//        return dao.addCkList(vo);
	//    }
	//
	//    // 체크리스트 삭제
	//    public int deleteCkList(int ckContentNum) {
	//        return dao.deleteCkList(ckContentNum);
	//    }
	//
	//    // 카테고리 추가
	//    public int addCkCategory(CkVO vo) {
	//        return dao.addckCategory(vo);
	//    }
	//
	//    // 팁 수정
	//    public int setTip(CkVO vo) {
	//        return dao.setTip(vo);
	//    }
	//
	//    // 팁 추가
	//    public int addTip(CkVO vo) {
	//        return dao.addTip(vo);
	//    }
	//
	//    // 팁 삭제
	//    public int deleteTip(int ckNum) {
	//        return dao.deleteTip(ckNum);
	//    }
	//
	//    // 팁 전체 삭제
	//    public int deleteAllTips(int ckNum) {
	//        return dao.allDeleteTip(ckNum);
	//    }
	//
	//    // 팁 최신 조회
	//    public Collection<CkVO> tipRecentSearch(String ckCategory) {
	//        return dao.tipRecentSearch(ckCategory);
	//    }
	//
	//    // 팁 조회
	//    public Collection<CkVO> tipSearch(String ckCategory) {
	//        return dao.tipSearch(ckCategory);
	//    }
	//
	//    // 이전 카테고리 목록 조회
	//    public Collection<String> backCkCategoryList() {
	//        return dao.backCkCategoryList();
	//    }
	//
	//    // 이전 제목/날짜 목록
	//    public Collection<CkVO> backCkTitleList(String ckCategory) {
	//        return dao.backCkTitleList(ckCategory);
	//    }
	//
	//    // 이전 제목/내용 목록
	//    public Collection<CkVO> backCkListSearch() {
	//        return dao.backCkListSearch();
	//    }
	//
	//    // 이전 체크리스트 삭제
	//    public int deleteBackCkList(int ckContentNum) {
	//        return dao.backCkListDelete(ckContentNum);
	//    }

}