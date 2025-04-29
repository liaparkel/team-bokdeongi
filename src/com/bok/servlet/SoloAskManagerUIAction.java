package com.bok.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bok.model.SoloAskVO;
import com.bok.service.SoloAskService;

public class SoloAskManagerUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		Collection<SoloAskVO> soloList = new SoloAskService().getSoloAsk();

		
		HttpSession session = request.getSession(true);
		session.setAttribute("soloList", soloList);

		return "soloAskManagerUI.html";
	}

}
