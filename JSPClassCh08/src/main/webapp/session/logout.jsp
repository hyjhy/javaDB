<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession session1 = request.getSession(); // 변수 이름이 충돌하니까 변수를 변경한 것
session.invalidate();
response.sendRedirect("main.jsp");
%>