package com.bok.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bok.model.SoloAskVO;
import com.bok.service.SoloAskService;

public class SoloAskUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		// 폼에서 전송된 데이터 받기
		String askEmail = request.getParameter("email"); // 이메일
		String askPw = request.getParameter("password"); // 비밀번호
		String askTitle = request.getParameter("title"); // 제목
		String askContent = request.getParameter("content"); // 내용
		String secret = request.getParameter("secret"); // 비밀글 여부

		// 비밀번호와 이메일은 필수 항목이므로, 입력이 없으면 처리하지 않음
		if (askEmail != null && !askEmail.isEmpty() && askPw != null && !askPw.isEmpty() && askTitle != null
				&& !askTitle.isEmpty() && askContent != null && !askContent.isEmpty()) {

			// 비밀글 여부 확인 (체크박스 처리)
			int soloSecret = (secret != null && secret.equals("true")) ? 1 : 0;

			// SoloAskVO 객체 생성 및 데이터 저장
			SoloAskVO soloAskVO = new SoloAskVO();
			soloAskVO.setEmail(askEmail);
			soloAskVO.setAskPw(askPw);
			soloAskVO.setAskTitle(askTitle);
			soloAskVO.setSoloSecret(soloSecret);
			soloAskVO.setSoloContent(askContent);

			// 서비스에서 데이터를 DB에 저장
			SoloAskService soloAskService = new SoloAskService();
			soloAskService.addSoloAsk(soloAskVO); // DB에 저장하는 서비스 메서드 호출
		}

		// 2. 기존의 soloList를 가져오기
		SoloAskService ss = new SoloAskService();
		Collection<SoloAskVO> soloList = ss.getSoloAsk(); // DB에서 기존 질문 목록을
															// 가져옵니다.

		// 3. 세션에 soloList를 저장하여 JSP로 전달
		HttpSession session = request.getSession(true);
		session.setAttribute("soloList", soloList);

		// 4. JSP 페이지로 포워딩
		return "soloAskUI.jsp"; // 요청 처리 후 JSP 페이지로 이동
	}
}
