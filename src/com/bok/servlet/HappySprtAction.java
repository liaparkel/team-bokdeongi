package com.bok.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.SprtPersonVO;
import com.bok.service.SprtService;
import com.google.gson.Gson;

public class HappySprtAction implements Action {

    private SprtService service;

    public HappySprtAction() {
        service = new SprtService();
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        List<SprtPersonVO> list = service.getSprtPerson(3); // fkSprtNum=3 (행복주택)
        Gson gson = new Gson();
        String json = gson.toJson(list);

        request.setAttribute("json", json);
        return "ajax:";
    }
}
