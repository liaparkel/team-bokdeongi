package com.bok.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class SprtManagerDAO {
	//관리자가 지원금 정보에서 수정 버튼 클릭 시 select (-sprtPerson 값)
	public SprtPersonVO getSprtPerson(SqlSession session,int sprtpNum){
		return session.selectOne("bokMapper.getSprtPersonOne", sprtpNum);
	}
	//관리자가 지원금 정보에서 수정 버튼 클릭 시 select (-sprtContent 값)
	public List<SprtContentVO> getSprtContent(int sprtpNum){
		List<SprtContentVO> scList = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		try{
			scList = conn.selectList("bokMapper.getSprtContents",sprtpNum);
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return scList;
	}	

	//지원금 정보 추가 후 저장 버튼(person & content - insert)
	//특정 지원금 정보 내용 수정하기 누른 후 추가 버튼(insert)
	public boolean setAddSprt(SprtPersonVO sp, List<SprtContentVO> scList){
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		boolean result = false;
		try {
			int p = conn.insert("bokMapper.addSprtPerson", sp);
			int successCount = 0;

			Integer generatedKey = sp.getSprtpNum(); // MyBatis에서 selectKey로 가져와야 함

			for (SprtContentVO sc : scList) {
				sc.setFkSprtpNum(generatedKey);
				successCount += conn.insert("bokMapper.addSprtContent", sc);
			}

			if (p == 1 && successCount == scList.size()) {
				conn.commit();
				result = true;
			} else {
				conn.rollback(); // 부분 성공도 실패로 처리
			}

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		return result;
	}


	//특정 지원금 정보 내용 수정 수정 버튼(update)
	public boolean setSprt(SprtPersonVO sp, List<SprtContentVO> scList) {
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		boolean result = false;

		try {
			int p = conn.update("bokMapper.setSprtPerson", sp);
			int successCount = 0;

			for (SprtContentVO sc : scList) {
				successCount += conn.update("bokMapper.setSprtContent", sc);
			}

			if (p == 1 && successCount == scList.size()) {
				conn.commit();
				result = true;
			} else {
				conn.rollback(); // 부분 성공도 실패로 처리
			}

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		return result;
	}
	//지원금 정보 관리의 개별 내용 삭제버튼 누르면 모달창 그 후 진짜 삭제 
	//특정 지원금 정보 전체(person&content) 삭제 버튼(delete)
	public boolean removeSprt(int sprtpNum){
		SqlSession conn= DBCP.getSqlSessionFactory().openSession();
		boolean result = false;
		try{
			int i = conn.delete("bokMapper.removeSprtContent",sprtpNum);
			int j = conn.delete("bokMapper.removeSprtPerson",sprtpNum);

			if(j==1 && i>=0){
				conn.commit();
				result= true;
			}
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
		return result;
	}
	//지원금 분류 추가 후 저장 버튼(카테고리 insert)
	public boolean addSprtCategory(String category){
		SqlSession conn= DBCP.getSqlSessionFactory().openSession();
		boolean result = false;
		try{
			conn.insert("bokMapper.addSprtCategory",category);
			conn.commit();
			result=true;
		}catch (Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
		return result;
	}

	//이전 지원금 정보 관리의 카테고리 선택(청년, 대출, 행복주택 등)
	//사용자에게 이전 지원금 정보 제공(종료일 내림차순)
	public List<SprtPersonVO> getBfSprtPerson(int fkSprtNum) {
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		List<SprtPersonVO> list = null;
		try{
			list = conn.selectList("bokMapper.getBfSprtPersonM", fkSprtNum);
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}

		return list;
	}


}
