<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div>
	${currnetPage} / ${totalPage} / ${totalCount} / ${totalPage}/ ${endPage} / ${pageSize}
</div>
	<div class="container">
		<form action="./multiDelete.do" method="post" onsubmit="return chkSubmit()">
			<table class="table table-hover">
				<thead>
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
								<!-- TODO 005 페이징 처리된 전체 글의 개수를 통한 연번 처리 -->
								<td>
									${totalCount - ((currentPage-1)*pageSize) - vs.index}
								</td>
								<td>${dto.name}</td>
								
								<td>
									<c:choose>
										<c:when test="${dto.depth>0}">
											<span style="margin-left: ${dto.depth*20}px">
												<img alt="reply" src="./img/reply.png" style="width: 16px; height: 16px; vertical-align: middle;" >
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
				
				
			</table>
		</form>
		
		<!-- 페이징 공간 -->
		<div style="text-align: center; margin-top: 20px">
		<!-- 처음으로 / 이전그룹 -->
		<c:if test="${startPage > 1}">
			<a href="./pagingBoard.do?page=1">처음으로</a>
			<a href="./pagingBoard.do?page=${startPage-1}">이전그룹</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:choose>
				<c:when test="${i== currentPage }">
					<span style="font-weight: bold;">${i}</span>
				</c:when>
				<c:otherwise>
					<a href="./pagingBoard.do?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		
		<c:if test="${endPage < totalPage}">
			<a href="./pagingBoard.do?page=${endPage+1 }">다음그룹</a>
			<a href="./pagingBoard.do?page=${totalPage}">끝</a>
		</c:if>
			
		</div>
	</div>

</body>
</html>