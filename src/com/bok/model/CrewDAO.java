package com.bok.model;

//import org.apache.ibatis.session.SqlSession;

public class CrewDAO {
	
	// 로그인
	public String loginCrew(CrewVO vo) {
//		 NullPointException
		String name = "";
		try {
//			name = conn.selectOne("bokMapper.selectLogin", vo);
			if (name == null) {
				name = "다시 확인하세요.";
			} 
//			return name;
			//conn.commit(); insert, update, delete에 사용 / 조회는 X
		} catch (Exception e) {
//			conn.rollback();
		} finally {
//			conn.close();
		}
		return name;
	}
}
