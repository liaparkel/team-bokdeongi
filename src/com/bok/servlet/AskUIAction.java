package com.bok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AskUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// 단순히 askUI.html 뷰 이름만 반환
		return "askUI.html";
	}
}
