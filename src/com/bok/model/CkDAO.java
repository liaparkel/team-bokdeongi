package com.bok.model;

import java.util.Collection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;




public class CkDAO {

static SqlSessionFactory sqlSessionFactory = DBCP.getSqlSessionFactory();

    // 체크리스트 전체 조회
    public Collection<CkVO> ckListInfo(String category) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.ckListInfo", category);
        }
    }

    // 체크리스트 최신순 조회
    public Collection<CkVO> ckListRecentInfo(String category) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.ckListRecentInfo", category);
        }
    }

    // 체크리스트 제목, 내용 수정
    public int setCkList(CkVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.update("bokMapper.setCkList", vo);
            session.commit();
            return result;
        }
    }

    // 체크리스트 추가
    public int addCkList(CkVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.insert("bokMapper.addCkList", vo);
            session.commit();
            return result;
        }
    }

    // 체크리스트 삭제
    public int deleteCkList(int ckContentNum) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.delete("bokMapper.deleteCkList", ckContentNum);
            session.commit();
            return result;
        }
    }

    // 카테고리 추가
    public int addckCategory(CkVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.insert("bokMapper.addckCategory", vo);
            session.commit();
            return result;
        }
    }

    // 팁 수정
    public int setTip(CkVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.update("bokMapper.setTip", vo);
            session.commit();
            return result;
        }
    }

    // 팁 추가
    public int addTip(CkVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.insert("bokMapper.addTip", vo);
            session.commit();
            return result;
        }
    }

    // 팁 삭제
    public int deleteTip(int ckNum) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.delete("bokMapper.deleteTip", ckNum);
            session.commit();
            return result;
        }
    }

    // 팁 전체 삭제
    public int allDeleteTip(int ckNum) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.delete("bokMapper.allDeleteTip", ckNum);
            session.commit();
            return result;
        }
    }

    // 팁 최신 조회
    public Collection<CkVO> tipRecentSearch(String ckCategory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.TipRecentSearch", ckCategory);
        }
    }

    // 팁 조회
    public Collection<CkVO> tipSearch(String ckCategory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.TipSearch", ckCategory);
        }
    }

    // 이전 카테고리 목록 조회
    public Collection<String> backCkCategoryList() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.BackCkCategoryList");
        }
    }

    // 이전 제목/날짜 목록
    public Collection<CkVO> backCkTitleList(String ckCategory) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.BackCkTitleList", ckCategory);
        }
    }

    // 이전 제목/내용 목록
    public Collection<CkVO> backCkListSearch() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("bokMapper.BackCkListSearch");
        }
    }

    // 이전 체크리스트 삭제
    public int backCkListDelete(int ckContentNum) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.delete("bokMapper.backCkListDelete", ckContentNum);
            session.commit();
            return result;
        }
    }
}