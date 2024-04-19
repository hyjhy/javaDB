<%@ page import="com.test.main.Boxdrum"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String number = request.getParameter("number");
String sum = request.getParameter("sum");
String brand = request.getParameter("brand");
String memo = request.getParameter("memo");
String img = request.getParameter("img");

Boxdrum drum = new Boxdrum();
drum.setName(name);
drum.setNumber(number);
drum.setSum(sum);
drum.setBrand(brand);
drum.setMemo(memo);
drum.setImg(img);

session.setAttribute("drum", drum);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
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

	<table>
		<tr>
			<td colspan="5"
				style="text-align: center; height: 30px; line-height: 30px">
				<h3>상품 등록 완료</h3> 아래와 같이 상품 등록이 완료 되었습니다.<br />
			</td>
		</tr>
		<tr>
		</tr>
		<tr>
			<td class="title">상 품 명</td>
			<td class="title">상품 코드</td>
			<td class="title">판 매 가</td>
			<td class="title">제조사</td>
			<td class="title">상품 코드</td>
		</tr>
		<tr>
			<td class="content"><a href="drum03.jsp">${sessionScope.drum.name }</a></td>
			<td class="content">${drum.sum }</td>
			<td class="content">${drum.number }</td>
			<td class="content">${drum.brand }</td>
			<td class="content">${drum.memo }</td>
		</tr>
		<c:if test="${not empty brum02 }">
			<c:forEach var="b" items="${bList }">
				<tr>
					<td>${sessionScope.drum.name }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty bList }">
			<tr>
				<td colspan="5">입력된 상품이 없습니다.</td>
			</tr>
		</c:if>
		
		
		
		
		
		
	</table>
	
	
	<p>
	<a href="drum"><input type="button" value="상품 등록하기" /></a>
	</p>

</body>
</html>