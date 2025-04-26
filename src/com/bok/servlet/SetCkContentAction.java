package com.bok.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.CkVO;
import com.bok.service.CkService;
import com.google.gson.Gson;

public class SetCkContentAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		   BufferedReader reader = request.getReader();
		    StringBuilder sb = new StringBuilder();
		    String line;

		    while ((line = reader.readLine()) != null) {
		        sb.append(line);
		    }
		    String body = sb.toString();
		    System.out.println("받은 데이터: " + body);

		    // 직접 파싱 (진짜 간단하게)
		    String title = body.split("\"title\":\"")[1].split("\"")[0];
		    String content = body.split("\"content\":\"")[1].split("\"")[0];

		    System.out.println("title: " + title);
		    System.out.println("content: " + content);

		    CkVO vo = new CkVO();
		    vo.setCkTitle(title);
		    vo.setCkContent(content);

		    CkService service = new CkService();
		    service.setCkList(vo);

		    return "setCkContentUI.html";
	}

}
