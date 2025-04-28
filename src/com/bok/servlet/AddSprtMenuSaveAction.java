package com.bok.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.service.SprtManagerService;

public class AddSprtMenuSaveAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		String category = request.getParameter("addSprtMenu");
		if (category != null && !category.isEmpty()){
			SprtManagerService service = new SprtManagerService();
			boolean isSuccess = service.addSprtCategory(category);
			if(isSuccess){
				return "sprtManagerUI.jsp"; 
			}else{
				request.setAttribute("message", "등록 실패!");
				return "tm.jsp"; 
			}


		}

		return null;
	}

}
