package com.bok.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bok.model.SprtContentVO;
import com.bok.model.SprtPersonVO;
import com.bok.service.SprtManagerService;

public class SetSprtUpdateAction implements Action {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        try {
            int sprtpNum = Integer.parseInt(request.getParameter("sprtpNum"));
//            int fkSprtNum = Integer.parseInt(request.getParameter("fkSprtNum"));
            String sprtTitle = request.getParameter("sprtTitle");
            String sprtSummary = request.getParameter("sprtSummary");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String sprtLink = request.getParameter("sprtLink");

            SprtPersonVO sp = new SprtPersonVO();
            sp.setSprtpNum(sprtpNum);
//            sp.setFkSprtNum(fkSprtNum);
            sp.setTitle(sprtTitle);
            sp.setSummary(sprtSummary);
            sp.setStart(startDate);
            sp.setEnd(endDate);
            sp.setLink(sprtLink);


            String[] sprtpcNumList = request.getParameterValues("sprtpcNumList"); 
            String[] sprtSubTitleList = request.getParameterValues("sprtSubTitleList"); 
            String[] sprtTextList = request.getParameterValues("sprtTextList"); 

            List<SprtContentVO> scList = new ArrayList<>();

            if (sprtSubTitleList != null && sprtTextList != null && sprtpcNumList != null) {
                for (int i = 0; i < sprtSubTitleList.length; i++) {
                    SprtContentVO sc = new SprtContentVO();
                    sc.setSprtpcNum(Integer.parseInt(sprtpcNumList[i])); 
                    sc.setSubtitle(sprtSubTitleList[i]);
                    sc.setContent(sprtTextList[i]);
                    scList.add(sc);
                }
            }

            SprtManagerService service = new SprtManagerService();
            boolean result = service.setSprt(sp, scList);


            if (result) {
                return "sprtManagerUI.jsp";
            } else {
                return "tm.jsp"; 
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "tm.jsp";
        }
    }
}
