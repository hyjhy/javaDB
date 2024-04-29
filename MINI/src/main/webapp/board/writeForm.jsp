<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/formcheck.js"></script> 
</head>
<body>
<!-- header  -->
		<%@ include file="../page/header.jsp" %>
	<h2>추억을 담는 공간</h2>
	<form action="membershipList" id="membershipList" method="post"
				enctype="multipart/form-data">
	
	
	
	
	
	<div>
	<label for="file1">이미지 파일</label>
	<input type="file" name="file1" id="file1" />
	</div>
	
	

<div>
	<label for="name">name</label>
	<input type="text" name="name" id="name" />
	</div>
	
	<div>
	<label for="pass">password</label>
	<input type="password" name="pass" id="pass" />
	</div>
	
	<div>
	<label for="title">title</label>
	<input type="text" name="title" id="title" />
	</div>
	
	<div>
	<input type="submit" value="등록하기" />
	</div>
	
	
	
	</form>
	
	<!-- footer  -->
		<%@ include file="../page/footer.jsp" %>
</body>
</html>