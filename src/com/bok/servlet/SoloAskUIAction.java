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
		
		SoloAskService ss = new SoloAskService();
		
		Collection<SoloAskVO> soloList = ss.getSoloAsk();
		HttpSession session = request.getSession(true);// 公炼扒 技记 积己
		session.setAttribute("soloList", soloList);
		
		return "soloAskUI.jsp";
	}

}
