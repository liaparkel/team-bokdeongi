package com.bok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.bok.servlet.Action;

public class SoloAskDetailUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// 더 이상 session.setAttribute 하지 않습니다.
		// AJAX 모달이 `soloAskDetailCheck`로 JSON을 받아와 렌더링하므로
		// 단순히 detail HTML을 반환만 하면 됩니다.
		return "soloAskDetailUI.html";
	}
}
