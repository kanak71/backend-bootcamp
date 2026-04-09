<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- TODO 109 모든 JSP의 GNB(Global Navigation Bar) Header -->
<!-- 관리자 모드에서만 작성 -->
<body>
	<c:choose>
		<c:when test="${sessionScope.loginDto == null}">
			<c:redirect url="./" />
		</c:when>
		

			<c:otherwise>
				<h3>관리자 모드</h3>
				<div>
					<span>${loginDto.name}님 환영합니다. (등급 : ${loginDto.auth})</span>
				</div>
				<div>
					<a href="./loginServlet.do">로그아웃</a>
				</div>
				<div>
					<a href="./userListStateServlet.do">회원전체 조회(사용)</a>
				</div>
				<div>
					<a href="./userListServlet.do">회원전체 조회</a>
				</div>
			</c:otherwise>
	
	</c:choose>
</body>
</html>