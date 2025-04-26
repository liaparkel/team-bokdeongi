package com.bok.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class BfSprtUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		return "bfSprtUI.html";
	}

}
