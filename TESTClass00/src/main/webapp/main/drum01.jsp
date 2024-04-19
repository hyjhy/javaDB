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
<style type="text/css">
* {
	text-align: center;
}

textarea {
	resize: none;
	text-align: left;
}
</style>
</head>
<body>
	<form action="drumList" method="post">
		<h2>상품 등록하기</h2>
		<p>
			상품명 : <input type="text" name="name">
		</p>
		<p>
			판매가 : <input type="number" name="number">
		</p>
		<p>
			상품코드 : <input type="number" name="sum">
		</p>
		<p>
			제조사 : <select name="brand">
				<option class="a">삼성전자</option>
				<option class="a">엘지전자</option>
			</select> ( 삼성 아님 엘지지~~ )
		</p>
		<textarea name="memo" rows="10" cols="50">* 상품 상세설명</textarea>
		<p>
			상품 이미지 : <input type="file" name="img" />
		</p>
		<span> <input type="reset" value="다시쓰기" />
		</span> <span> <input type="submit" value="등록하기" />
		</span> <span> <input type="submit" value="취소하기" />
		</span>
	</form>
</body>
</html>