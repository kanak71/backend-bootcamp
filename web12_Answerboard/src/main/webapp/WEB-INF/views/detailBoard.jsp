<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
</head>
<%@ include file="./header.jsp" %>
<body>

	<div class="container">
		<table class="table table-contensed">
			<col width="30%">
			<col width="70%">
			<tbody>
				<tr>
					<th class="info">아이디</th>
					<td>${dto.id}</td>
				</tr>
				
				<tr>
					<th class="info">제목</th>
					<td>${dto.title}</td>
				</tr>
				
				<tr>
					<th class="info">내용</th>
					<td>${dto.content}</td>
				</tr>
				
				<tr>
					<th class="info">등록일</th>
					<td>
						<c:out value="${dto.content}"></c:out>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2">
						<div class="btn-group btn-group-justified">
							<input type="hidden" name="seq" value="${dto.seq}">
							
							<!-- 관리자에 의한 상세 페이지에서 글 삭제 버튼 -->
							<c:if test="${loginDto.auth eq 'ROLE_ADMIN'}">
								<div>
									<button class="btn btn-danger" onclick="del(this)">완전삭제</button>
								</div>
							</c:if>
							
							<!-- 게시글이 해당 게시글이라면 글 수정 -->
							<c:if test="${loginDto.id eq dto.id}">
								<div>
									<button class="btn btn-info" onclick="modify(this)">내글수정</button>
								</div>
							</c:if>
							<!-- 모든 사용자는 답글 -->
							<div class="btn-group">
								<button class="btn btn-primary" onclick="reply(this)">답글작성</button>
							</div>
							
						</div>
					</th>
					
				</tr>
				
			</tfoot>
			
		</table>
		
	</div>
<%@ include file="./footer.jsp" %>
</body>
</html>