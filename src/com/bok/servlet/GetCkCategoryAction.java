package com.bok.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.CkVO;
import com.bok.service.CkService;
import com.google.gson.Gson;

public class GetCkCategoryAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        CkService service = new CkService();
        List<CkVO> categoryList = service.getCkCategory();

        Gson gson = new Gson();
        return gson.toJson(categoryList);
    }
}
