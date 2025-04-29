package com.bok.servlet;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bok.model.SoloAskVO;
import com.bok.service.SoloAskService;

public class SearchEmailAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		return "soloAskUI.html";
	}
}
