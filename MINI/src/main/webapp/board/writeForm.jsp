<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>글쓰기</title>
<style type="text/css">
* {
	text-decoration: none;
	margin: 0;
	padding: 0;
	list-style: none;
}

h2 {
	text-align: center;
}

#writer {
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	justify-items: center;
	align-items: center;
	position: relative;
	top: 0;
	left: 50%;
	transform: translate(-50%)
}

section {
	height: 40vh;
}
#raising{

}
</style>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/formcheck.js"></script>
</head>
<body>
	<!-- header  -->
	<%@ include file="../page/header.jsp"%>
	<h2>추억을 담는 공간</h2>
	<form action="writeProcess" id="writeProcess" method="post"
		enctype="multipart/form-data">
		<section id="writer">
			<div>
				<label for="file1">이미지 파일</label> <input type="file" name="file1"
					id="file1" />
			</div>
			<div id="raising">
				<label for="name">name</label><br> <input type="text"
					name="name" id="name" /><br> <label for="pass">password</label><br>
				<input type="password" name="pass" id="pass" /><br> <label
					for="title">title</label><br> <input type="text" name="title"
					id="title" /><br> <input type="submit" value="등록하기" />
			</div>
		</section>
	</form>
	<!-- footer  -->
	<%@ include file="../page/footer.jsp"%>
</body>
</html>