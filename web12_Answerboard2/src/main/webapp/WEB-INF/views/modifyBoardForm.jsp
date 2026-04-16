<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정 폼</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div class="container">
		<div>parameter의 전송범위: 다음 페이지까지 ${param.seq}</div>
		
		<form action="./modifyBoard.do" method="post">
			<input type="hidden" name="seq" value="${param.seq}">
			<table class="table table-contensed">
				<col width="30%">
				<col width="70%">
				<tbody>
					<tr>
						<th class="success">아이디</th>
						<td>${dto.id}</td>
					</tr>
					<tr>
						<th class="success">제목</th>
						<td>${dto.title}</td>
					</tr>
					<tr>
						<th class="success">내용</th>
						<td>
							<textarea rows="5" class="form-control" name="content" id="content" required="required">${dto.content}</textarea>
						</td>
					</tr>
					<tr>
						<th class="success">등록일</th>
						<td>${dto.regdate}</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="2" style="text-align: center;">
							<input type="submit" value="수정완료">
							<input type="button" value="뒤로가기" onclick="javascript:history.back(-1)">
						</th>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
<%@ include file="./footer.jsp" %>
</body>
</html>