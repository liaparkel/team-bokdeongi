<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String resultJson = (String) request.getAttribute("resultJson");
    out.print(resultJson);
%>