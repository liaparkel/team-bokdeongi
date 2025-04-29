package com.bok.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.CkContentVO;
import com.bok.model.CkVO;
import com.bok.service.CkService;
import com.google.gson.Gson;

public class GetCkHomeInfoAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String category = request.getParameter("category");

        CkService service = new CkService();
        CkVO ckInfo = service.getLatestCk(category);
        List<CkContentVO> contentList = null;
        
        if (ckInfo != null) {
            contentList = service.getCkContent(ckInfo.getCkNum());
        }

        Map<String, Object> result = new HashMap<>();
        result.put("ckInfo", ckInfo);
        result.put("contentList", contentList);

        Gson gson = new Gson();
        return gson.toJson(result);
    }
}
