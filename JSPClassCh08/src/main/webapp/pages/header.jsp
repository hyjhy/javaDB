<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#camera {
	width: 170px;
	height: 80px;
}
#user {
width: 50px;
height: 50px; 
}
</style>

<!-- header  -->
<div class="row border-bottom border-primary">
	<div class="col-4">
		<p>
			<img src="../images/camerayour.jpg" id="camera">
		</p>
	</div>
	<div class="col-8">
		<div class="row mt1">
			<div class="col">

				<ul class="nav justify-content-end">
					<c:if test="${sessionScope.isLogin }">
						<li><a class="nav-link" href="#"><img alt="user" src="../images/user.jpg" id="user"> ${sessionScope.id } 님</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link"
						href="${sessionScope.isLogin ? 'logout.jsp' : 'loginForm.jsp'}">
							${sessionScope.isLogin ? "로그아웃" : "로그인"}</a></li>
					<li class="nav-item"><c:if test="${not sessionScope.isLogin }">
							<a class="nav-link" href="#">회원가입</a>
						</c:if> <c:if test="${sessionScope.isLogin }">
							<a class="nav-link" href="#">정보수정</a>
						</c:if></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col text-end">&nbsp;</div>
		</div>

	</div>
</div>