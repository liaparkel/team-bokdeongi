package com.bok.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.SprtContentVO;
import com.bok.model.SprtPersonVO;
import com.bok.service.SprtManagerService;

public class AddSprtInfoAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String sprtNumStr = request.getParameter("sprtNum");
        if (sprtNumStr != null) {
            int sprtNum = Integer.parseInt(sprtNumStr);

            SprtManagerService service = new SprtManagerService();
            String category = service.getAddCategory(sprtNum);

            request.setAttribute("sprtNum", sprtNum);
            request.setAttribute("category", category);
        }

        return "addSprtInfo.jsp";
    }
}

	
