<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/comm.css">
<title>전체사용자</title>
</head>

<body>
	<!-- 다른 곳에 있는 JSP를 module로 사용하여 HTML 합쳐준다 -->
	<%@ include file="Header.jsp"%>
	<hr>


	<h2>회원 목록</h2>
	<table class="member-table">

		<thead>
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>이메일</th>
				<th>권한</th>
				<th>상태</th>
				<th>가입일</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="member" items="${lists}">
				<tr>
					<td>${member.id}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td>${member.auth eq 'ROLE_USER' ? '사용자':'관리자'}</td>
					<td><c:choose>
							<c:when test="${member.enable eq 'Y'}">사용중</c:when>
							<c:otherwise>탈퇴</c:otherwise>
						</c:choose></td>
					<td>${member.joindate}</td>
				</tr>
			</c:forEach>
		</tbody>

		<tfoot>
			<tr>
				<th colspan="6">
					<button onclick="history.back()">뒤로가기</button>
				</th>
			</tr>
		</tfoot>

	</table>

</body>
</html>