package com.bok.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.SprtPersonVO;
import com.bok.service.SprtService;
import com.google.gson.Gson;

public class YouthSprtAction implements Action {

    private SprtService service;

    public YouthSprtAction() {
        service = new SprtService();
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        List<SprtPersonVO> list = service.getSprtPerson(1); // fkSprtNum=1 (Ã»³â)
        Gson gson = new Gson();
        String json = gson.toJson(list);

        request.setAttribute("json", json);
        return "ajax:";
    }
}
