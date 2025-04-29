package com.bok.servlet;

import javax.servlet.http.HttpServletRequest;
import com.bok.model.CkVO;
import com.bok.service.CkService;

public class AddCkCancelAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		try {
			String category = request.getParameter("category"); // category 받기

			// category로 최신 ckNum 조회
			CkVO latestCk = new CkService().getLatestCk(category);
			if (latestCk == null) {
				request.setAttribute("resultJson", "{\"success\":false, \"message\":\"ckNum 찾을 수 없음\"}");
				return "json";
			}
			int ckNum = latestCk.getCkNum();

			boolean result = new CkService().cancelCkCategory(ckNum);

			if (result) {
				request.setAttribute("resultJson", "{\"success\":true}");
			} else {
				request.setAttribute("resultJson", "{\"success\":false, \"message\":\"삭제 실패\"}");
			}
			return "json";

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("resultJson", "{\"success\":false, \"message\":\"서버 오류\"}");
			return "json";
		}
	}
}