package com.bok.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.SprtContentVO;
import com.bok.model.SprtPersonVO;
import com.bok.service.SprtManagerService;

public class AddSprtInfoSaveAction implements Action {

	@Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        
        String title = request.getParameter("sprtTitle");
        String summary = request.getParameter("sprtSummary");
        String link = request.getParameter("sprtLink");
        String start = request.getParameter("startDate");
        String end = request.getParameter("endDate");

        // PK 값들 받아오기
        String fkSprtNum = request.getParameter("fkSprtNum");

        String[] subtitles = request.getParameterValues("sprtSubTitleList");
        String[] contents = request.getParameterValues("sprtTextList");

        SprtPersonVO person = new SprtPersonVO();
        person.setTitle(title);
        person.setSummary(summary);
        person.setLink(link);
        person.setStart(start != null && !start.isEmpty() ? start : null);
        person.setEnd(end != null && !end.isEmpty() ? end : null);
        person.setFkSprtNum(Integer.parseInt(fkSprtNum));

        // PK 값 설정
        person.setFkSprtNum(fkSprtNum != null ? Integer.parseInt(fkSprtNum) : 0);
       
        List<SprtContentVO> contentList = new ArrayList<>();
        if (subtitles != null && contents != null) {
            for (int i = 0; i < subtitles.length; i++) {
                SprtContentVO content = new SprtContentVO();
                content.setSubtitle(subtitles[i]);
                content.setContent(contents[i]); 
                content.setFkSprtpNum(person.getSprtpNum()); 
                contentList.add(content);
            }
        }
       

        // 서비스 호출
        SprtManagerService service = new SprtManagerService();
        boolean success = service.setAddSprt(person, contentList);

        if (success) {
            return "sprtManagerUI.html"; 
        } else {
            request.setAttribute("message", "등록 실패!");
            return "sprtManagerUI.html"; 
        }
    }
}
