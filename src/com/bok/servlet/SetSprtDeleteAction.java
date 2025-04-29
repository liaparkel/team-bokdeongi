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
	            return "sprtManagerUI.html";  
	        }

	        
	        SprtManagerService service = new SprtManagerService();
	        boolean isDeleted = service.removeSprt(Integer.parseInt(sprtpNum));

	        if (isDeleted) {
	            request.setAttribute("alertMessage", "삭제 성공");
	        } else {
	            request.setAttribute("alertMessage", "삭제 실패. 다시 시도해 주세요.");
	        }

	        return "sprtManagerUI.html";
	    }
	}
