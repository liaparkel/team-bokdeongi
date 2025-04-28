package com.bok.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bok.model.CrewDAO;
import com.bok.model.CrewVO;
import com.bok.service.CrewService;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		String page = "loginUI.html";
		
		String crewId = request.getParameter("id");
		String crewPw = request.getParameter("pw");

		CrewService cs = new CrewService();
		String name = cs.loginCrew(new CrewVO(crewId, crewPw));

		if (name != null) {
			HttpSession session = request.getSession(true);// 公炼扒 技记 积己
			session.setAttribute("crewName", name);
			page = "login.jsp";
		}
		return page;
	}

}
