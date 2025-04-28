package com.bok.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bok.model.SoloAskVO;
import com.bok.service.SoloAskService;

public class SoloAskDetailUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		String askNum = request.getParameter("askNum");
		
		SoloAskService ss = new SoloAskService();
		SoloAskVO sv = ss.soloAskDetail(askNum);
		
//		if (askNum != null) {
			HttpSession session = request.getSession(true);// 公炼扒 技记 积己
			session.setAttribute("askDetail", sv);
//		}
		return "soloAskDetailUI.jsp";
	}

}
