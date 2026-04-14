<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>게시글 전체조회</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div class="container">
		<form action="./multiDelete.do" method="post" onsubmit="return chkSubmit()">
			<table class="table table-hover">
			<thead>
				<tr class="info">
			
				<tr class="info">
					<th>
						<input type="checkbox" id="chkbox" onclick="checkAll(this.checked)">
					</th>
					<th>연번</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			
			<tbody>
				<c:if test="${empty lists}">
					<tr>
						<td colspan="5" class="text-center text-primary">
							-- 작성된 글이 없습니다 --
						</td>
					</tr>
				</c:if>
				
				<c:if test="${not empty lists}">
					<c:set var="size" value="${fn:length(lists)}"/>
					<c:forEach var="dto" items="${lists}" varStatus="vs">
						<tr>
							<td class="text-center">
								<input type="checkbox" name="ch" value="${dto.seq}">
							</td>
							<td>
								${size - vs.index}
							</td>
							<td>${dto.name}</td>
							
							
							<td>
								<c:choose>
								
									<c:when test="${dto.depth>0 }">
										<span style="margin-left: ${dto.depth * 20}px">
											<img alt="reply" src="./img/reply.png" style="width: 16px; height: 16px; vertical-align: midle;">
										</span>
									</c:when>
								
									<c:otherwise>
										<span></span>
									</c:otherwise>
								</c:choose>
								
								
								<c:choose>
									<c:when test="${dto.delflag eq 'Y'}">
										<span style="font-size: 10px; color: #aaa">관리자에 의해 삭제된 글</span>
									</c:when>
									<c:otherwise>
										<a href="./detailBoard.do?seq=${dto.seq}">${dto.title}</a>
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<fmt:parseDate value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss" var="regdate"/>
								<fmt:formatDate value="${regdate}" pattern="yyy.MM.dd"/>
							</td>
							
							
						</tr>
						
					</c:forEach>
				</c:if>
			</tbody>
			
			<tfoot>
				<tr>
					<th colspan="5" class="text-center">
					
						<input type="submit" class="btn btn-success" value="다중삭제01">
						<input type="button" class="btn btn-info" value="다중삭제02" onclick="chSubmit(event)">
						
						<input type="button" class="btn btn-primary" value="새글작성" onclick="location.href='./writeBoard.do'">
					</th>
				</tr>
			</tfoot>
			</table>
		</form>
		
	
	</div>
<!-- 푸터 -->
<%@ include file="./footer.jsp" %>
</body>
</html>