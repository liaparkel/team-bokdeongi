package com.bok.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CkHomeUIAction implements Action {

	@Override
	public String execute(HttpServletRequest requests) throws ServletException, IOException {

		// TODO Auto-generated method stub

		return "ckHomeUI.html";
	}

}
