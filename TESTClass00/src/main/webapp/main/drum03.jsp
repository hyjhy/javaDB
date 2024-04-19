<%@ page import="com.test.main.Boxdrum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String number = request.getParameter("number");
String sum = request.getParameter("sum");

Boxdrum drum = new Boxdrum();
drum.setName(name);
drum.setNumber(number);
drum.setSum(sum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid blue;
	border-collapse: collapse;
}

td {
	border: 1px solid blue;
	height: 30px;
}

.title {
	width: 100px;
	padding-left: 5px;
}

.content {
	width: 250px;
	padding-left: 5px;
}
</style>
</head>
<body>
	<form action="drum01.jsp" method="post">
		<table>
			<tr>
				<td colspan="5"
					style="text-align: center; height: 30px; line-height: 30px">
					<h3>${drum.name }</h3>
				</td>
			</tr>
			<tr>
				<td colspan="5"
					style="text-align: center; height: 30px; line-height: 30px">${drum.img }
					<img src="${drum.img }" />
				</td>
			</tr>
			<tr>
				<td class="title">제조사 : </td>
				<td class="title">판 매 가 :</td>
				<td class="title">상품 코드 :</td>
				<td class="title"></td>
			</tr>
			<tr>
				<td class="content">${sessionScope.drum.name }</td>
				<td class="content">${drum.number }</td>
				<td class="content">${drum.sum }</td>
				<td class="content">${drum.sum }</td>
				<td class="content">${drum.sum }</td>
			</tr>
		</table>
		<span> <a href="">상품 등록하기</a>
		</span> <span> <a href="">상품 수정하기</a>
		</span> <span> <a href="">상품 삭제하기</a>
		</span> <span> <a href="deum02.jsp">상품 리스트</a>
		</span>
	</form>
</body>
</html>