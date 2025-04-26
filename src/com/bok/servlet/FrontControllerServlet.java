package com.bok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/controller")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public FrontControllerServlet() {

	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd==null) cmd = "mainUI"; 
		Action a= ActionFactory.getAction(cmd);
		String url=a.execute(request);
		
		if ("json".equals(url)) {
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			String resultJson = (String) request.getAttribute("resultJson");
			response.getWriter().write(resultJson);
			return; // forward ¾È ÇÏ°í ³¡³¿
		}

		
		request.getRequestDispatcher("/"+url).forward(request, response);
	}  

}

