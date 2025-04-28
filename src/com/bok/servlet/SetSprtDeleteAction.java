package com.bok.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.service.SprtManagerService;



public class SetSprtDeleteAction implements Action {
	
	 @Override
	    public String execute(HttpServletRequest request) throws ServletException, IOException {
	        String sprtpNum = request.getParameter("sprtpNum");

	        if (sprtpNum == null || sprtpNum.isEmpty()) {
	            request.setAttribute("message", "삭제할 항목이 없습니다.");
	            return "tm.jsp";  
	        }

	        
	        SprtManagerService service = new SprtManagerService();
	        boolean isDeleted = service.removeSprt(Integer.parseInt(sprtpNum));
	        System.out.println("액션이야:"+isDeleted);
	        if (isDeleted) {
	            request.setAttribute("message", "삭제 성공");
	            return "sprtManagerUI.jsp";  
	        } else {
	            request.setAttribute("message", "삭제 실패");
	            return "tm.jsp"; 
	        }
	    }
	}