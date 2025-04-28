package com.bok.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


public class SprtManagerDAO {
	//관리자가 지원금 정보에서 수정 버튼 클릭 시 select (-sprtPerson 값)
	public SprtPersonVO getSprtPerson(SqlSession session,int sprtpNum){
		return session.selectOne("bokMapper.getSprtPersonOne", sprtpNum);
	}
	//관리자가 지원금 정보에서 수정 버튼 클릭 시 select (-sprtContent 값)
	public List<SprtContentVO> getSprtContent(SqlSession session,int sprtpNum){
		return session.selectList("bokMapper.getSprtContents",sprtpNum);
	}	

	//지원금 정보 추가 후 저장 버튼(person & content - insert)
	//특정 지원금 정보 내용 수정하기 누른 후 추가 버튼(insert)
	public boolean setAddSprt(SqlSession session, SprtPersonVO sp, List<SprtContentVO> scList) {
		int personInsertResult = session.insert("bokMapper.addSprtPerson", sp);

		Integer generatedKey = sp.getSprtpNum();
		int successCount = 0;

		for (SprtContentVO sc : scList) {
			sc.setFkSprtpNum(generatedKey);
			successCount += session.insert("bokMapper.addSprtContent", sc);
		}

		return personInsertResult == 1 && successCount == scList.size();
	}

	//특정 지원금 정보 내용 수정 수정 버튼(update)
	public boolean setSprt(SqlSession session, SprtPersonVO sp, List<SprtContentVO> scList) {
		int personResult = session.update("bokMapper.setSprtPerson", sp);
		int contentSuccessCount = 0;

		for (SprtContentVO sc : scList) {
			contentSuccessCount += session.update("bokMapper.setSprtContent", sc);
		}

		return personResult == 1 && contentSuccessCount == scList.size();
	}

	//지원금 정보 관리의 개별 내용 삭제버튼 누르면 모달창 그 후 진짜 삭제 
	//특정 지원금 정보 전체(person&content) 삭제 버튼(delete)
	public boolean removeSprt(SqlSession session, int sprtpNum) {
		int contentDelete = session.delete("bokMapper.removeSprtContent", sprtpNum);
		int personDelete = session.delete("bokMapper.removeSprtPerson", sprtpNum);
		System.out.println("dao야contetn;"+contentDelete);
		System.out.println("dao야persohn;"+personDelete);
		return personDelete == 1 && contentDelete >= 0;
	}

	//지원금 분류 추가 후 저장 버튼(카테고리 insert)
	public boolean addSprtCategory(SqlSession session, String category) {
		int result = session.insert("bokMapper.addSprtCategory", category);
		return result == 1;
	}


	//이전 지원금 정보 관리의 카테고리 선택(청년, 대출, 행복주택 등)
	//사용자에게 이전 지원금 정보 제공(종료일 내림차순)
	public List<SprtPersonVO> getBfSprtPerson(SqlSession session, int fkSprtNum) {
		return session.selectList("bokMapper.getBfSprtPersonM", fkSprtNum);
	}

	//카테고리에 해당하는 이전 지원금 정보 제공(종료일 내림차순, Pagination)
	public List<SprtPersonVO> getPagedBfSprtPersonM(SqlSession session, int fkSprtNum, PagingVO paging) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("fkSprtNum", fkSprtNum);
	    params.put("startRow", paging.getStartRow() + 1);
	    params.put("endRow", paging.getEndRow());
	    return session.selectList("bokMapper.getPagedBfSprtPersonM", params);
	}



}
