package com.bok.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.SprtPersonVO;
import com.bok.service.SprtService;
import com.google.gson.Gson;

public class LoanSprtAction implements Action {

    private SprtService service;

    public LoanSprtAction() {
        service = new SprtService();
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        List<SprtPersonVO> list = service.getSprtPerson(2); // fkSprtNum=2 (¥Î√‚)
        Gson gson = new Gson();
        String json = new Gson().toJson(list);

        request.setAttribute("json", json);
        return "ajax:";
    }
}
