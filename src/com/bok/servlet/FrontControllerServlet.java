package com.bok.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bok.model.AskVO;
import com.bok.model.SoloAskManagerVO;
import com.bok.model.SoloAskVO;
import com.bok.service.AskService;
import com.bok.service.SoloAskManagerService;
import com.bok.service.SoloAskService;
import com.google.gson.Gson;

@WebServlet("/controller")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");
		if (cmd == null)
			cmd = "mainUI";

		// 1) 상세보기 비밀번호 확인 AJAX 분기
		if ("soloAskDetailCheck".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			String askNum = request.getParameter("askNum");
			String password = request.getParameter("password");

			SoloAskVO vo = new SoloAskService().soloAskDetail(askNum);
			boolean ok = vo != null && vo.getAskPw().equals(password);

			Map<String, Object> result = new HashMap<>();
			result.put("success", ok);
			if (ok) {
				Map<String, String> detail = new HashMap<>();
				detail.put("askTitle", vo.getAskTitle());
				detail.put("soloContent", vo.getSoloContent());
				detail.put("soloAnswer", vo.getSoloAnswer());
				result.put("detail", detail);
			}

			writeJson(response, result);
			return;
		}

		// 2) 1:1 문의 전체 목록 AJAX 분기
		if ("soloAskUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<SoloAskVO> list = new SoloAskService().getSoloAsk();
			writeJson(response, list);
			return;
		}

		// 3) 이메일 검색 AJAX 분기
		if ("searchEmail".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			String email = request.getParameter("email");
			Collection<SoloAskVO> list = new SoloAskService().searchEmail(email);
			if (list == null || list.isEmpty()) {
				list = new SoloAskService().getSoloAsk();
			}
			writeJson(response, list);
			return;
		}

		// 4) 상세보기 데이터 AJAX 분기
		if ("soloAskDetailUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			String askNum = request.getParameter("askNum");
			SoloAskVO vo = new SoloAskService().soloAskDetail(askNum);
			if (vo == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				writeJson(response, Collections.singletonMap("error", "문의글이 없습니다."));
				return;
			}

			Map<String, String> detail = new HashMap<>();
			detail.put("askTitle", vo.getAskTitle());
			detail.put("soloContent", vo.getSoloContent());
			detail.put("soloAnswer", vo.getSoloAnswer() != null ? vo.getSoloAnswer() : "");

			writeJson(response, detail);
			return;
		}

		// 5) 답변 저장 분기
		if ("soloAskAnswer".equals(cmd)) {
			String askNum = request.getParameter("askNum");
			String answer = request.getParameter("answer");

			SoloAskManagerVO vo = new SoloAskManagerVO();
			vo.setAskNum(askNum);
			vo.setSoloAnswer(answer);

			boolean ok = new SoloAskManagerService().soloAskSend(vo);
			if (ok) {
				response.setStatus(HttpServletResponse.SC_OK);
			} else {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			return;
		}

		// 6) FAQ 전체 목록 AJAX 분기
		if ("askUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<AskVO> faqList = new AskService().getFaq();
			writeJson(response, faqList);
			return;
		}

		// Action 처리 (뷰 이름 or JSON 문자열)
		Action action = ActionFactory.getAction(cmd);

		String view = action.execute(request); // 변수명을 'view'로 통일

		// (1) 지원금/체크리스트 관련 AJAX JSON
		if ("getSprtCategory".equals(cmd) || "getSprtPerson".equals(cmd) || "getSprtContent".equals(cmd)
				|| "getBfSprtPerson".equals(cmd) || "getBfSprtManagerPerson".equals(cmd) || "getCkCategory".equals(cmd)
				|| "getCkHomeInfo".equals(cmd)) {
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write(view);
			return;
		}

		// (2) JSON 결과 포맷 분기
		if ("json".equals(view)) {
			response.setContentType("application/json; charset=UTF-8");
			String resultJson = (String) request.getAttribute("resultJson");
			response.getWriter().write(resultJson);
			return;
		}

		// 그 외: JSP/HTML 포워드
		request.getRequestDispatcher("/" + view).forward(request, response);
	}

	/**
	 * 간편 JSON 응답 유틸
	 */
	private void writeJson(HttpServletResponse response, Object data) throws IOException {
		String json = new Gson().toJson(data);
		response.setContentType("application/json; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.write(json);
			out.flush();
		}
	}
}
