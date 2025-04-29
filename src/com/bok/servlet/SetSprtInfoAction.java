package com.bok.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.SprtContentVO;
import com.bok.model.SprtInfoVO;
import com.bok.model.SprtPersonVO;
import com.bok.service.SprtManagerService;

public class SetSprtInfoAction implements Action{

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
        String sprtpNumStr = request.getParameter("sprtpNum");
        int sprtpNum = Integer.parseInt(sprtpNumStr);

        SprtManagerService service = new SprtManagerService();
        SprtPersonVO person = service.getSprtPerson(sprtpNum);
        List<SprtContentVO> contentList = service.getSprtContent(sprtpNum);
        String category = service.getSprtCategory(sprtpNum);

        request.setAttribute("category", category);
        request.setAttribute("person", person);
        request.setAttribute("contentList", contentList);

        return "setSprtInfo.jsp";
	}
}
