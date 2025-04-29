package com.bok.servlet;

import javax.servlet.http.HttpServletRequest;
import com.bok.model.CkContentVO;
import com.bok.model.CkVO;
import com.bok.service.CkService;
import java.util.ArrayList;
import java.util.List;

public class AddCkSaveAction implements Action {

	@Override
	public String execute(HttpServletRequest request) {
		try {
			String category = request.getParameter("category");
			String tip = request.getParameter("tip");

			String[] titles = request.getParameterValues("title");
			String[] contents = request.getParameterValues("content");

			CkVO latestCk = new CkService().getLatestCk(category);
			if (latestCk == null) {
				request.setAttribute("resultJson", "{\"success\":false, \"message\":\"ckNum 찾을 수 없음\"}");
				return "json";
			}
			int ckNum = latestCk.getCkNum();

			List<CkContentVO> contentList = new ArrayList<>();
			if (titles != null && contents != null) {
				for (int i = 0; i < titles.length; i++) {
					CkContentVO vo = new CkContentVO();
					vo.setTitle(titles[i]);
					vo.setContent(contents[i]);
					contentList.add(vo);
				}
			}

			boolean result = new CkService().saveCkContents(ckNum, tip, contentList);

			if (result) {
				request.setAttribute("resultJson", "{\"success\":true}");
			} else {
				request.setAttribute("resultJson", "{\"success\":false, \"message\":\"저장 실패\"}");
			}
			return "json";

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("resultJson", "{\"success\":false, \"message\":\"서버 오류\"}");
			return "json";
		}
	}
}
