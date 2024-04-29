<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
<!-- header  -->
		<%@ include file="../page/header.jsp" %>
		<!-- content -->
	<form action="loginProcess" method="post" id="loginForm">
		<div id="login">
			<p>
				<label for="userId">아이디</label>
				<input type="text" id="userId" name="id" />
			</p>
			<p>
				<label for="userPass">비밀번호</label> <input type="password"
					id="userPass" name="pass" />
			</p>
		</div>
		
<!-- 		<div class="row my-5" id="global-content"> -->
<!-- 			<div class="col"> -->
<!-- 				<form class="my-5" id="loginForm" action="" method=""> -->
					<h2 class="fw-bold">Member Login</h2>
					<fieldset>	
						<legend>Member Loin</legend>
						<div id="login">
							<p>
								<label for="userId" class="labelStyle">아이디</label>
								<input type="text" id="userId" name="id" />
							</p>
							<p>
								<label for="userPass" class="labelStyle">비밀번호</label>
								<input type="password" id="userPass" name="pass"/>
							</p>
						</div>
							<input type="submit" value="로그인" id="btnLogin" />
						<p id="btn1">
							<input type="checkbox" id="saveId" value="savedIdYes" />
							<label for="saveId">아이디저장</label>	
							<input type="checkbox" id="secure" value="secureYes" />
							<label for="secure">보안접속</label>	
						</p>
						<p id="btn2">
							<input type="button" value="회원가입" id="btnJoin" />
							<input type="button" value="아이디/비밀번호 찾기" id="btnSearch" />
						</p>
					</fieldset>
				</form>
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</form> -->
<!-- footer  -->
		<%@ include file="../page/footer.jsp" %>
</body>
</html>