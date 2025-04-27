package com.bok.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import com.bok.model.SprtPersonVO;
import com.bok.model.PagingVO;
import com.bok.service.SprtManagerService;
import com.google.gson.Gson;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GetBfSprtManagerPersonAction implements Action {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String sprtNumStr = request.getParameter("sprtNum");
        String pageIndexStr = request.getParameter("pageIndex");

        int sprtNum = Integer.parseInt(sprtNumStr);
        int pageIndex = (pageIndexStr == null || pageIndexStr.isEmpty()) ? 1 : Integer.parseInt(pageIndexStr);
        
        // pageSize는 서버에서 관리 (한 곳만)
        final int pageSize = 5;

        SprtManagerService service = new SprtManagerService();
        PagingVO paging = new PagingVO(pageIndex, pageSize);

        List<SprtPersonVO> list = service.getBfSprtPerson(sprtNum, paging);
        int totalCount = service.getBfSprtPersonCount(sprtNum);

        // pageSize를 클라이언트에 같이 전달
        Map<String, Object> result = new HashMap<>();
        result.put("list", list);
        result.put("totalCount", totalCount);
        result.put("pageSize", pageSize);

        return new Gson().toJson(result);
    }
}
