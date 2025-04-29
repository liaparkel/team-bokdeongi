package com.bok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.service.SprtManagerService;

public class SprtContentDeleteAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String sprtpNum = request.getParameter("sprtpNum");

        if (sprtpNum == null || sprtpNum.isEmpty()) {
            request.setAttribute("alertMessage", "삭제할 항목이 없습니다.");
            return "sprtBfManagerUI.html"; 
        }

        SprtManagerService service = new SprtManagerService();
        boolean isDeleted = service.removeSprt(Integer.parseInt(sprtpNum));

        if (isDeleted) {
            request.setAttribute("alertMessage", "삭제 성공");
        } else {
            request.setAttribute("alertMessage", "삭제 실패. 다시 시도해 주세요.");
        }

        return "sprtBfManagerUI.html";
    }
}
