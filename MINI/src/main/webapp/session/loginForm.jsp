<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>LoginForm</title>
<style type="text/css">
* {
	text-decoration: none;
	margin: 0;
	padding: 0;
	list-style: none;
}

section {
	margin: 0 10%;
}

#login {
	text-align: center;
	margin-top: 15%;
	margin-bottom: 15%;
}
.member{
margin: 20px
}
</style>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/formcheck1.js"></script>
</head>
<body>
	<!-- header  -->
	<%@ include file="../page/header.jsp"%>
	<!-- content -->
	<form action="loginProcess" method="post" id="loginForm">
		<section>
			<div id="login">
				<p class="member">
					<label for="userId" class="labelStyle">아이디</label> <input
						type="text" id="userId" name="id" />
				</p>
				<p class="member">
					<label for="userPass" class="labelStyle">비밀번호</label> <input
						type="password" id="userPass" name="pass" />
				</p>
				<input type="submit" value="로그인" id="btnLogin" />
				<p id="btn1">
					<input type="checkbox" id="saveId" value="savedIdYes" />
					<label for="saveId">아이디저장</label>
					<input type="checkbox" id="secure" value="secureYes" />
					<label for="secure">보안접속</label>
				</p>
			</div>
		</section>
	</form>
	<footer>
		<%@ include file="../page/footer.jsp"%>
	</footer>
</body>
</html>