<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>수정하는 페이지</title>
<style type="text/css">
    * {
	text-decoration: none;
	list-style: none;
}
.content {
text-align: center;
}

h2{
text-align: center;
}

.btna{
 text-align: center;
}
.container {
margin-top: 13%;
margin-bottom: 13%;
}
.interval{
margin: 15px;
}
    </style>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/formcheck.js"></script>
</head>
<body>
		<!-- header  -->
		<%@ include file="../page/header.jsp"%>
		<!-- content -->
	<div class="container">
		<div class="row my-5" id="global-content">
			<div class="col">
				<div class="row text-center">
					<div class="col">
						<h2 class="fs-3 fw-bold">게시 글 수정하기</h2>
					</div>
				</div>
				<!--
					게시 글을 수정하기 위해서는 테이블에서 게시 글을 유일하게 구분할 수 있는 
					데이터가 필요하다. 아래에서 no는 테이블에서 하나의 게시 글을 유일하게
					구분할 수 있는 데이터로 아래 폼이 서버로 전송될 때 이 no도 같이 서버로
					전송되어야 게시 글 정보를 제대로 수정할 수 있기 때문에 화면에는 보이지 
					않고 폼이 전송될 때 요청 파라미터에 추가될 수 있도록 hidden 폼 컨트롤로
					폼에 추가하였다.
				-->
				<form name="updateForm" action="updateProcess" id="updateForm"
					class="content" method="post" ${not empty board.file1 ?"" : "enctype='multipart/form-data'"}>
					<input type="hidden" name="no" value="${board.no}"> <input
						type="hidden" name="pageNum" value="${pageNum}">
					<div class="interval">
						<label for="name" class="form-label">글쓴이</label> <input
							type="text" class="form-control" name="name" id="name"
							placeholder="작성자를 입력해 주세요" value="${board.name}">
					</div>
					<div class="interval">
						<label for="pass" class="form-label">비밀번호</label> <input
							type="password" class="form-control" name="pass" id="pass">
					</div>
					<div class="interval">
						<label for="title" class="form-label">제 목</label> <input
							type="text" class="form-control" name="title" id="title"
							value="${board.title}">
					</div>
					<c:if test="${ empty board.file1 }">
						<div class="col-8 offset-md-2">
							<label for="content" class="form-label">파 일</label> <input
								type="file" class="form-control" name="file1" id="file1" />${board.file1}
						</div>
					</c:if>
					<div class="btna">
						<input type="submit" value="수정하기" class="btn btn-primary" />
						&nbsp;&nbsp;<input type="button" value="취소하기"
							onclick="history.back()" />
							<!-- location.href='boardList'?pageNum=${pageNum} -->
					</div>
				</form>
			</div>
		</div>
	</div>
		<!-- footer  -->
		<%@ include file="../page/footer.jsp"%>
	<script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>