package com.bok.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bok.model.AskVO;
import com.bok.service.AskService;

public class AskUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		AskService as = new AskService();
		Collection<AskVO> faqList = as.getFaq();
		
//		request.setAttribute("faqList", faqList);
		HttpSession session = request.getSession(true);// 公炼扒 技记 积己
		session.setAttribute("faqList", faqList);
		
		return "askUI.jsp";
	}

}
