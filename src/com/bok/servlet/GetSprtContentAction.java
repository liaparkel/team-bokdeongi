package com.bok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import com.bok.model.SprtContentVO;
import com.bok.service.SprtService;
import com.google.gson.Gson;
import java.util.List;

public class GetSprtContentAction implements Action {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String sprtpNumStr = request.getParameter("sprtpNum");
        int sprtpNum = Integer.parseInt(sprtpNumStr);

        SprtService service = new SprtService();
        List<SprtContentVO> list = service.getSprtContent(sprtpNum);

        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
