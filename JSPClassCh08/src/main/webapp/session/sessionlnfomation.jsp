<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    // Httpsession - 내장객체 session
    // application 내장객체 - ServletContext
    session.setMaxInactiveInterval(60); // 30분 정도를 설정 하고 있다.
    Calendar ca = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
새로운 세션 여부 : <%= session.isNew() %><br>
세션ID : <%= session.getId() %><br>
<%
ca.setTimeInMillis(session.getCreationTime());
%>
세션 생성 시간 : <%= String.format("%TY년 %Tm월 %Td일 %TT" , ca,ca,ca,ca) %><br>
세션 생성 시간 : <%= String.format("%1$TY년 %1$Tm월 %1$Td일 %1$TT",ca) %><br>
<%
ca.setTimeInMillis(session.getLastAccessedTime());
%>
마지막 접근 시간 : <%= formatter.format(ca.getTime())%> 새로고침을 한 시간<br>
세션 유효시간 : <%= session.getMaxInactiveInterval() %><br>
</body>
</html>