<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	text-decoration: none;
	margin: 0;
	padding: 0;
	list-style: none;
}

.textbox p {
	margin: 0;
	text-align: left;
}

.textbox {
	margin: 0 auto;
	width: 200px;
}

.mit {
	text-align: center;
	margin: 10px;
}

h2 {
	text-align: center;
}
#belief{
color: crimson;
font-size: 14px;
}
</style>
</head>
<body>
	<!-- header  -->
	<%@ include file="../page/header.jsp"%>
	<!-- 		content -->
	<section id="main">
		
		<form action="membershipList" id="membershipList" method="post">

		 <h2>회원가입</h2>
			<div class="textbox">
				<p>이름</p>
				<input type="text" placeholder="너의 이름은" maxlength="5" name="name"
					id="name">
			</div>
			<div class="textbox">
				<p>이메일</p>
				<input type="email" placeholder="이메일 입력해주세요" name="email1"
					id="email1">
			</div>
			<div class="textbox">
				<p>전화번호</p>
				<input type="number" placeholder=" - 빼고 입력해주세요." maxlength="11"
					name="member" id="member">
			</div>
			<div class="textbox">
				<p>아이디</p>
				<input type="text" placeholder="아이디를 입력해주세요" maxlength="10"
					name="id" id="id">
			</div>
			<div class="textbox">
				<p>비밀번호</p>
				<input type="password" placeholder="비밀번호를 입력해주세요" maxlength="10"
					name="pass" id="pass">
			</div>
			<div class="textbox">
				<p>비밀번호 확인</p>
				<p id="belief">( 비밀번호는 10자리 이내로<br>
				입력해주세요. )</p>
				<input type="password" placeholder="비밀번호를 입력해주세요" maxlength="10"
					name="pass2" id="pass2">
			</div>

			<div class="mit">
				<input type="submit" value="등록하기" />
			</div>




		</form>





	</section>

	<!-- footer  -->
	<%@ include file="../page/footer.jsp"%>
</body>
</html>