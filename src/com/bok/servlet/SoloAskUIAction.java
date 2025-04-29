package com.bok.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bok.model.SoloAskVO;
import com.bok.service.SoloAskService;

public class SoloAskUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// 1) 폼에서 넘어온 저장용 파라미터 확인
		String email = request.getParameter("email");
		String askPw = request.getParameter("password");
		String askTitle = request.getParameter("title");
		String content = request.getParameter("content");
		String secret = request.getParameter("secret");

		// email · password · title · content 가 모두 들어왔으면 '저장'으로 간주
		if (email != null && askPw != null && askTitle != null && content != null) {
			SoloAskVO vo = new SoloAskVO();
			vo.setEmail(email);
			vo.setAskPw(askPw);
			vo.setAskTitle(askTitle);
			vo.setSoloContent(content);
			// 체크박스 처리 (체크 시 "true" 넘어오므로)
			vo.setSoloSecret("true".equals(secret) ? 1 : 0);

			// DB에 저장 (성공 여부는 무시)
			new SoloAskService().addSoloAsk(vo);
		}

		// 2) 저장 여부와 상관없이 최신 목록 조회
		Collection<SoloAskVO> soloList = new SoloAskService().getSoloAsk();

		// 3) 세션에 담아서 soloAskUI.html 쪽 JS가 AJAX 없이도
		// session.getAttribute("soloList") 로 활용하게 할 수도 있고,
		// JS로 AJAX(fetch) 호출해서 사용하게 할 수도 있습니다.
		HttpSession session = request.getSession(true);
		session.setAttribute("soloList", soloList);

		// 4) 최종 뷰
		return "soloAskUI.html";
	}
}
