<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 후 페이지</title>
</head>
<!-- TODO 102 로그인 후 이동하는 페이지 -->
<body>
	<!-- session scope를 사용 -->
	<c:set var="loginDto" value="${sessionScope.loginDto}" />
	
	<h2>
		<c:choose>
			<c:when test="${loginDto.auth eq 'ROLE_ADMIN'}">관리자</c:when>
			<c:otherwise>일반사용자</c:otherwise>
		</c:choose>
		모드
	</h2>
	
	<div>
		<span>${loginDto.name}님 환영합니다. (등급: ${loginDto.auth})</span>
	</div>
	
	<!-- TODO 103 로그아웃 -->
	<div>
		<a href="./loginServlet.do">로그아웃</a>
	</div>
	
	<!-- 사용자 마이페이지 -->
	<c:if test="${loginDto.auth eq 'ROLE_USER'}">
		<div>
			<a href="./userInfoServlet.do">마이페이지</a>
		</div>
	</c:if>
	
	<!-- 관리자 메뉴 기능 -->
	<c:if test="${loginDto.auth eq 'ROLE_ADMIN'}">
		<!-- 회원상태(가능) 전체조회 -->
		<div>
			<a href="./userListStateServlet.do">회원상태 조회</a>
		</div>
		<!-- 회원 전체 조회 -->
		<div>
			<a href="./userListServlet.do">회원 전체 조회</a>
		</div>
	</c:if>
	
	
	
</body>
</html>








