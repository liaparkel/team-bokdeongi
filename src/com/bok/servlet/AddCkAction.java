package com.bok.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.CkVO;
import com.bok.service.CkService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class AddCkAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
	    BufferedReader reader = request.getReader();
	    StringBuilder sb = new StringBuilder();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        sb.append(line);
	    }

	    Gson gson = new Gson();
	    JsonObject jsonObject = gson.fromJson(sb.toString(), JsonObject.class);

	    String category = jsonObject.get("category").getAsString();

	    CkService service = new CkService();
	    CkVO vo = new CkVO();
	    vo.setckCategory(category);
	    vo.setCkDate(Date.valueOf(LocalDate.now())); // 오늘 날짜 저장

	    int result = service.addCkCategory(vo);

	    request.setAttribute("resultJson", "{\"success\": " + (result > 0) + "}");
	    
	    return "addCk.jsp"; // ⭐ "json"이 아니라 "json.jsp" 로 리턴
	}
}
