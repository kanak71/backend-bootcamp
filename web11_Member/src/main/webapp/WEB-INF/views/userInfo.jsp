<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css">
</head>
<!-- TODO 104 회원 상세 조회 페이지 -->
<body>
	<div class="container">
		<table class="table table-striped">
			<thead class="table-primary">
				<tr>
					<th>아이디</th>
					<th>성명</th>
					<th>이메일</th>
					<th>사용여부</th>
					<th>권한</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${userInfo.id}</td>
					<td>${userInfo.name}</td>
					<td>${userInfo.email}</td>
					<td>
						<c:choose>
							<c:when test="${userInfo.enable eq 'Y'}">사용</c:when>
							<c:otherwise>탈퇴</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${userInfo.auth eq 'ROLE_ADMIN'}">관리자</c:when>
							<c:otherwise>사용자</c:otherwise>
						</c:choose>
					</td>
					<td>
						${userInfo.joindate}
					</td>
				</tr>
				
			</tbody>
			<tfoot>
				<tr>
				
					<th colspan="6" style="text-align: center;">
						<!-- 회원정보 수정 -->
						<input class="btn btn-success btn-lg" type="button" value="수정" id="modifyBtn">
						<!-- 회원 탈퇴 -->
						<input class="btn btn-danger btn-lg" type="button" value="탈퇴" id="deleteBtn">
					</th>
				</tr>
			</tfoot>
		</table>
	</div>
	<!-- TODO 106 회원탈퇴 -->
	<script type="text/javascript">
		document.getElementById("modifyBtn").onclick = function(){
			console.log("수정화면 이동");
			location.href="./userModifyServlet.do";
		}
		
		document.getElementById("deleteBtn").onclick = function(){
			console.log("회원탈퇴");
			if(confirm("정말 탈퇴하시겠습니까?")){
				location.href="./delUserServlet.do?"
			}
		}
	</script>
	
</body>
</html>






