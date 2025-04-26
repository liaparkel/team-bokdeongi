package com.bok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.SprtPersonVO;
import com.bok.service.SprtService;
import com.google.gson.Gson;

import java.util.List;

public class GetSprtPersonAction implements Action {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String sprtNumStr = request.getParameter("sprtNum");
        int sprtNum = Integer.parseInt(sprtNumStr);

        SprtService service = new SprtService();
        List<SprtPersonVO> list = service.getSprtPerson(sprtNum);

        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
