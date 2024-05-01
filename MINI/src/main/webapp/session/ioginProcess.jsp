<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- DB연결 해서 로그인 정보를 불러오는 공간 -->
<c:set var="ADMIN_ID" value="admin" scope="application" />
<c:set var="ADMIN_PASS" value="1234" scope="application" />
<!-- 로그인 성공 -->
<c:if
	test="${param.id == applicationScope.ADMIN_ID && param.pass == applicationScope.ADMIN_PASS }">
	<c:set var="isLogin" value="true" scope="session" />
	<c:set var="id" value="admin" scope="session" />

	<c:redirect url="/boardList" />
</c:if>
<!-- 로그인 실패 -->
<c:if
	test="${not(param.id == applicationScope.ADMIN_ID && param.pass == applicationScope.ADMIN_PASS) }">
	<script>
		alert("아이디 또는 비밀번호가 틀립니다.")
		history.back();
	</script>
</c:if>