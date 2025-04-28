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
        if (cmd == null) cmd = "mainUI";

        Action action = ActionFactory.getAction(cmd);
        String result = action.execute(request);

        // (1) 지원금/체크리스트 관련 명령어 → JSON 바로 응답
        if ("getSprtCategory".equals(cmd) || 
            "getSprtPerson".equals(cmd) || 
            "getSprtContent".equals(cmd) || 
            "getBfSprtPerson".equals(cmd) || 
            "getBfSprtManagerPerson".equals(cmd) ||
            "getCkCategory".equals(cmd) || 
            "getCkHomeInfo".equals(cmd)) {

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

        // (3) 이메일 검색 AJAX 처리
        if ("searchEmail".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
            String email = request.getParameter("email");
            Collection<SoloAskVO> list = new SoloAskService().searchEmail(email);
            if (list == null || list.isEmpty()) {
                list = new SoloAskService().getSoloAsk();
            }
            writeJson(response, list);
            return;
        }

        // (4) FAQ 전체 목록 AJAX 처리
        if ("askUI".equals(cmd) && "true".equals(request.getParameter("ajax"))) {
            Collection<AskVO> faqList = new AskService().getFaq();
            writeJson(response, faqList);
            return;
        }

        // (5) 그 외 결과 처리
        if ("json".equals(result)) {
            response.setContentType("application/json; charset=UTF-8");
            String resultJson = (String) request.getAttribute("resultJson");
            response.getWriter().write(resultJson);
        } else {
            request.getRequestDispatcher("/" + result).forward(request, response);
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
