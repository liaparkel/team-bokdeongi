package com.bok.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bok.model.SoloAskVO;
import com.bok.service.SoloAskService;

public class SearchEmailAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		String email = request.getParameter("email");

		SoloAskService ss = new SoloAskService();

		Collection<SoloAskVO> sa = ss.searchEmail(email);

		if (sa != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("soloList", sa);
		} else {
			sa = ss.getSoloAsk();
			HttpSession session = request.getSession(true);
			session.setAttribute("soloList", sa);
		}

		return "soloAskUI.jsp";
	}

}
