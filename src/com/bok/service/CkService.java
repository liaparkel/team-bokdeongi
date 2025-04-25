package com.bok.service;

import java.sql.Date;
import java.util.Collection;
import com.bok.model.CkDAO;
import com.bok.model.CkVO;

public class CkService {
	 private CkDAO dao = new CkDAO();
	
	// 체크리스트 전체 조회
    public Collection<CkVO> getCkListInfo(String category) {
        return dao.ckListInfo(category);
    }

    // 체크리스트 최신순 조회
    public Collection<CkVO> getCkListRecentInfo(String category) {
        return dao.ckListRecentInfo(category);
    }

    // 체크리스트 제목/내용 수정
    public int updateCkList(CkVO vo) {
        return dao.setCkList(vo);
    }

    // 체크리스트 추가
    public int addCkList(CkVO vo) {
        return dao.addCkList(vo);
    }

    // 체크리스트 삭제
    public int deleteCkList(int ckContentNum) {
        return dao.deleteCkList(ckContentNum);
    }

    // 카테고리 추가
    public int addCkCategory(CkVO vo) {
        return dao.addckCategory(vo);
    }

    // 팁 수정
    public int updateTip(CkVO vo) {
        return dao.setTip(vo);
    }

    // 팁 추가
    public int addTip(CkVO vo) {
        return dao.addTip(vo);
    }

    // 팁 삭제
    public int deleteTip(int ckNum) {
        return dao.deleteTip(ckNum);
    }

    // 팁 전체 삭제
    public int deleteAllTips(int ckNum) {
        return dao.allDeleteTip(ckNum);
    }

    // 팁 최신 조회
    public Collection<CkVO> getRecentTips(String ckCategory) {
        return dao.TipRecentSearch(ckCategory);
    }

    // 팁 조회
    public Collection<CkVO> getTips(String ckCategory) {
        return dao.TipSearch(ckCategory);
    }

    // 이전 카테고리 목록 조회
    public Collection<String> getBackCkCategoryList() {
        return dao.BackCkCategoryList();
    }

    // 이전 제목/날짜 목록
    public Collection<CkVO> getBackCkTitleList(String ckCategory) {
        return dao.BackCkTitleList(ckCategory);
    }

    // 이전 제목/내용 목록
    public Collection<CkVO> getBackCkListSearch() {
        return dao.BackCkListSearch();
    }

    // 이전 체크리스트 삭제
    public int deleteBackCkList(int ckContentNum) {
        return dao.backCkListDelete(ckContentNum);
    }
}