<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>추억을 담는 공간</title>
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

.navcontent {
	display: flex;
	justify-content: end;
	margin: 40px;
}

button {
	margin: 20px;
}

section {
	margin: 0 10%;
}

.nav {
	margin: 2px;
}

table {
	margin: 0 auto;
}

tr, th, td {
	text-align: center;
	padding: 20px 70px 20px;
}
</style>

</head>
<body>
	<div class="container">
		<!-- header  -->
		<%@ include file="../page/header.jsp"%>
		<!-- content -->
		<h2>게시 글 리스트</h2>
		<section>
			<form name="searchForm" id="searchForm" action="#">
				<div class="navcontent">
					<select name="type" class="nav">
						<option value="title">제목</option>
						<option value="writer">작성자</option>
						<option value="content">내용</option>
					</select> <input type="text" name="keyword" class="nav" id="keyword" /> <input
						type="submit" value="검 색" class="nav" />
				</div>
			</form>
			<div class="writer">
				<a href="writeForm"><button id=writer2>글쓰기</button> </a>
			</div>
			<div class="row my-3">
				<div class="col">
					<table>
						<thead>
							<tr class="table-dark">
								<th>NO</th>
								<th>title</th>
								<th>name</th>
								<th>time</th>
								<th>view count</th>
							</tr>
						</thead>
						<tbody class="text-secondary">
							<c:if test="${ not empty bList }">
								<c:forEach var="b" items="${bList}">
									<tr>
										<td>${ b.no }</td>
										<td><a
											href="boardDetail?no=${b.no}&pageNum=${currentPage}"
											class="text-decoration-none link-secondary">${ b.title }</a></td>
										<td>${b.name }</td>
										<td><fmt:formatDate value="${b.regDate }"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td>${b.readCount }</td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${empty bList }">
								<tr>
									<td colspan="5" class="text-center">게시 글이 존재하지 않습니다.</td>
								</tr>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center">
					<c:if test="${startPage > pageGroup}">
						<li class="page-item"><a class="page-link"
							href="boardList?pageNum=${startPage - pageGroup}">Pre</a></li>
					</c:if>
					<c:forEach var="i" begin="${startPage}" end="${endPage}">
						<!-- 현재 페이지인 경우 -->
						<c:if test="${ i == currentPage }">
							<li class="page-item active"><span class="page-link">${i}</span>
							</li>
						</c:if>
						<!-- 현재 페이지가 아닌 경우  -->
						<c:if test="${ i != currentPage }">
							<li class="page-item"><a class="page-link"
								href="boardList?pageNum=${i}">${i}</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${endPage < pageCount}">
						<li class="page-item"><a class="page-link"
							href="boardList?pageNum=${startPage + pageGroup}">Next</a></li>
					</c:if>
				</ul>
			</nav>
		</section>
		<!-- end main -->
		<!-- footer  -->
		<%@ include file="../page/footer.jsp"%>
	</div>
	<script src="bootstrap/bootstrap.bundle.min.js"></script>
</body>
</html>