<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#a {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin: 10px;
}

.b{
width: 250px;
}

#camera {
	width: 170px;
	height: 80px;
}

#user {
	width: 50px;
	height: 50px;
}

span{
margin: 20px;
}
</style>

<!-- header  -->
<div class="" id="a">
	
	<div class="b">
		<p></p>
	</div>
	
	
	
	
	
	
	<div class="b">
		<p>
			<a href="../session/main.jsp"><img src="../images/camerayour.jpg" id="camera"></a>
		</p>
	</div>


	





	<div class="b">
		<c:if test="${sessionScope.isLogin }">
			<span> <a class="" href="#"><img alt="user"
					src="../images/user.jpg" id="user"> ${sessionScope.id } 님</a>
			</span>
		</c:if>
		<span class=""> <a class=""
			href="${sessionScope.isLogin ? 'logout.jsp' : 'loginForm.jsp'}">
				${sessionScope.isLogin ? "로그아웃" : "로그인"}</a>
		</span> <span class=""> <c:if test="${not sessionScope.isLogin }">
				<a class="" href="#">회원가입</a>
			</c:if> <c:if test="${sessionScope.isLogin }">
			</c:if>
		</span>
	</div>



</div>
<%-- end header --%>