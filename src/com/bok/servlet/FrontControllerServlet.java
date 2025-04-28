package com.bok.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

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
		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			cmd = "mainUI";
		}

		// 1:1 문의 전체 목록 AJAX 분기
		if ("soloAskUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<SoloAskVO> list = new SoloAskService().getSoloAsk();
			writeJson(response, list);
			return;
		}

		// **이메일 검색 AJAX 분기 추가**
		if ("searchEmail".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			String email = request.getParameter("email");
			Collection<SoloAskVO> list = new SoloAskService().searchEmail(email);
			if (list == null || list.isEmpty()) {
				list = new SoloAskService().getSoloAsk();
			}
			writeJson(response, list);
			return;
		}

		// FAQ 전체 목록 AJAX 분기
		if ("askUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
			Collection<AskVO> faqList = new AskService().getFaq();
			writeJson(response, faqList);
			return;
		}

		// 그 외는 ActionFactory → Action → 뷰 포워드
		Action action = ActionFactory.getAction(cmd);
		String view = action.execute(request);

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

	private void writeJson(HttpServletResponse response, Object data) throws IOException {
		String json = new Gson().toJson(data);
		response.setContentType("application/json; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.write(json);
			out.flush();
		}
	}
}
