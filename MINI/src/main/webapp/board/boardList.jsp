<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	JSP 표준 태그 라이브러리(JSTL)를 사용하기 위한 taglib 지시자
	http://jakarta.apache.org, http://tomcat.apache.org 에서
	다운로드 하여 WEB-INF/lib 폴더에 추가해야 표준 태그를 사용할 수 있다. 
	JSTL의 코어 라이브러리는 말 그대로 JSTL의 가장 핵심적인 기능을 제공하는
	라이브러리로 프로그래밍 언어에서 일반적으로 제공하고 있는 변수 선언, 조건문,
	반복문에 해당하는 태그를 지원한다. 또한 익셉션, URL 저장, 데이터 출력과 관련된
	태그와 다른 JSP 페이지 호출(import, redirect)과 관련된 태그를 지원한다.	   
 --%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시 글 리스트</title>
    <link href="bootstrap/bootstrap.min.css" rel="stylesheet" >    
  </head>
  <body>
  	<div class="container">
		<!-- header  -->
		<%@ include file="../page/header.jsp" %>
  		<!-- content -->
  		<div class="row my-5 text-center">
  			<div class="col">
  				<h2 class="fs-3 fw-bold">게시 글 리스트</h2>
  			</div>
  		</div>  		
		<form name="searchForm" id="searchForm" action="#" 
			class="row justify-content-center my-3">
			<div class="col-auto">
				<select name="type" class="form-select">
					<option value="title">제목</option>
					<option value="writer">작성자</option>
					<option value="content">내용</option>
				</select>
			</div>
			<div class="col-4">
				<input type="text" name="keyword" class="form-control" id="keyword"/>
			</div>
			<div class="col-auto">
				<input type="submit" value="검 색" class="btn btn-primary"/>
			</div>
		</form>  		
  		<div class="row">
  			<div class="col text-end">
  				<a href="writeForm" class="btn btn-outline-success">글쓰기</a>
  				<a href="writeForm" class="btn btn-outline-success">글쓰기</a>
  			</div>
  		</div>
  		<div class="row my-3">  			
  			<div class="col">
  				<table class="table table-hover">
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
							<td><a href="boardDetail?no=${b.no}&pageNum=${currentPage}" 
									class="text-decoration-none link-secondary">${ b.title }</a></td>
<%-- 							<td>${ b.readCount }</td> --%>
						
							<td>
								<fmt:formatDate value="${b.regDate }" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							
							
						</tr>
						</c:forEach>
					</c:if>
			
					<c:if test="${ empty bList }">
						<tr>
							<td colspan="5" class="text-center">게시 글이 존재하지 않습니다.</td>
						</tr>
					</c:if>
					</tbody>
  				</table>
  			</div>  			
  		</div>
  		<div class="row">
  			<div class="col">
  				<nav aria-label="Page navigation">
				  <ul class="pagination justify-content-center">
				  	<c:if test="${startPage > pageGroup}">
				    	<li class="page-item">
				    		<a class="page-link" href="boardList?pageNum=${startPage - pageGroup}">Pre</a>
				    	</li>
				    </c:if>
				    
				    <c:forEach var="i" begin="${startPage}" end="${endPage}">
				    	<!-- 현재 페이지인 경우 -->
				    	<c:if test="${ i == currentPage }">
						    <li class="page-item active">
						    	<span class="page-link">${i}</span>
						    </li>
					    </c:if>
					    <!-- 현재 페이지가 아닌 경우  -->
					    <c:if test="${ i != currentPage }">
						    <li class="page-item">
						    	<a class="page-link" href="boardList?pageNum=${i}">${i}</a>
						    </li>
					    </c:if>
				    </c:forEach>
				    
				    <c:if test="${endPage < pageCount}">
				    	<li class="page-item">
				    		<a class="page-link" href="boardList?pageNum=${startPage + pageGroup}">Next</a>
				    	</li>
				    </c:if>
				  </ul>
				</nav>
  			</div>
  		</div>
<!-- footer  -->
		<%@ include file="../page/footer.jsp" %>
		
	</div>
    <script src="bootstrap/bootstrap.bundle.min.js"></script>
  </body>
</html>