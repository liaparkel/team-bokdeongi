package com.bok.servlet;

import javax.servlet.http.HttpServletRequest;

import com.bok.service.CkService;

public class AddCkAction implements Action {

    @Override
    public String execute(HttpServletRequest request) {

        try {
            // 1. 파라미터에서 category 이름 받아오기
            String category = request.getParameter("category");

            // 2. 유효성 체크
            if (category == null || category.trim().isEmpty()) {
                request.setAttribute("resultJson", "{\"success\":false, \"message\":\"카테고리명이 비어있습니다.\"}");
                return "json";
            }

            // 3. 서비스 호출
            String result = new CkService().addCkCategory(category.trim());

            // 4. 결과 처리
            if (result != null) {
                request.setAttribute("resultJson", "{\"success\":true, \"category\":\"" + result + "\"}");
            } else {
                request.setAttribute("resultJson", "{\"success\":false, \"message\":\"카테고리 추가 실패\"}");
            }

            return "json";

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("resultJson", "{\"success\":false, \"message\":\"서버 오류\"}");
            return "json";
        }
    }
}
