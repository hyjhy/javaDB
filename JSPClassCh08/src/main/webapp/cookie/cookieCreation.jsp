<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Cookie cookie = new Cookie("id", "midas");
cookie.setMaxAge(60*3); // 3분 정도 / 브라우저를 삭제시킨다. / 변수에 저장

response.addCookie(cookie);
response.addCookie(new Cookie("name", "john"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
쿠키 이름 : <%= cookie.getName() %><br>
쿠기 값 : <%= cookie.getValue() %><br>
쿠키 유효기간 : <%= cookie.getMaxAge() %>
</body>
</html>