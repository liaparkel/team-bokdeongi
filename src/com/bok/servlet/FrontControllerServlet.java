package com.bok.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.bok.model.AskVO;
import com.bok.model.SoloAskVO;
import com.bok.service.AskService;
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

			String json = new Gson().toJson(result);
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write(json);
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

		// 4) **상세보기 데이터 AJAX 분기** (추가된 부분)
		if ("soloAskDetailUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			String askNum = request.getParameter("askNum");
			SoloAskVO vo = new SoloAskService().soloAskDetail(askNum);

			Map<String, String> detail = new HashMap<>();
			detail.put("askTitle", vo.getAskTitle());
			detail.put("soloContent", vo.getSoloContent());
			detail.put("soloAnswer", vo.getSoloAnswer() != null ? vo.getSoloAnswer() : "");

			writeJson(response, detail);
			return;
		}

		// 5) FAQ 전체 목록 AJAX 분기
		if ("askUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<AskVO> faqList = new AskService().getFaq();
			writeJson(response, faqList);
			return;
		}

		Action action = ActionFactory.getAction(cmd);
		String result = action.execute(request);

		// (1) 지원금/체크리스트 관련 명령어 → JSON 바로 응답
		if ("getSprtCategory".equals(cmd) || "getSprtPerson".equals(cmd) || "getSprtContent".equals(cmd)
				|| "getBfSprtPerson".equals(cmd) || "getBfSprtManagerPerson".equals(cmd) || "getCkCategory".equals(cmd)
				|| "getCkHomeInfo".equals(cmd)) {

			response.setContentType("application/json; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result);
			return;
		}

		// (2) 1:1 문의 전체 목록 AJAX 처리
		if ("soloAskUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<SoloAskVO> list = new SoloAskService().getSoloAsk();
			writeJson(response, list);
			return;
		}

		// 지원금 API JSON 분기...
		if ("getSprtCategory".equals(cmd) || "getSprtPerson".equals(cmd) || "getSprtContent".equals(cmd)
				|| "getBfSprtPerson".equals(cmd) || "getBfSprtManagerPerson".equals(cmd)) {

			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write(view);
			return;
		}
		// result="json" 분기...
		else if ("json".equals(view)) {
			response.setContentType("application/json; charset=UTF-8");
			String resultJson = (String) request.getAttribute("resultJson");
			response.getWriter().write(resultJson);
			return;
		}
		// HTML/JSP 포워드
		else {
			request.getRequestDispatcher("/" + view).forward(request, response);
		}
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
