<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession session1 =request.getSession();
session.invalidate();
response.sendRedirect("/boardList");
%>