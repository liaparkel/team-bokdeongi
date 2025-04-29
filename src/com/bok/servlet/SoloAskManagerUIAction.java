// com/bok/servlet/SoloAskManagerUIAction.java
package com.bok.servlet;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import javax.servlet.ServletException;

public class SoloAskManagerUIAction implements Action {
	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// AJAX 로 목록을 가져오므로, 세션에 굳이 담을 필요 없이
		return "soloAskManagerUI.html";
	}
}
