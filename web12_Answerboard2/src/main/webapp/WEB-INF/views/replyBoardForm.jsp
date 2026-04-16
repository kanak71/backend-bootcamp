<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글입력 폼</title>
</head>
<script type="text/javascript" src="./js/reply.js" defer="defer"></script>
<%@ include file="./header.jsp" %>
<body>
	<div class="container">
		<form action="./replyBoard.do" method="post">
			<input type="hidden" name="seq" value="${param.seq}">
			<table class="table">
				<tbody>
					<tr>
						<th>아이디</th>
						<td class="form-group">
							<input type="text" class="form-control" name="id" value="${loginDto.id}" readonly="readonly">
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<td class="form-group">
							<input type="text" class="form-control" name="title" required="required">
						</td>
					</tr>
					<tr>
						<th id="contxt">내용<br>(원본)</th>
						<td class="form-group">
							<input type="hidden" value="y" id="chkContent">
							<input type="hidden" value="${dto.content}" id="hiddenContent">
							<textarea rows="5" class="form-control" name="content" id="txtArea" required="required">원본&gt;${dto.content}</textarea>
						</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td class="form-group" id="newDate"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="2">
							<input class="btn btn-primary btn-lg btn-block" type="submit" value="답글입력">
							<input class="btn btn-danger btn-lg btn-block" type="reset" value="초기화">
						</th>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
<%@ include file="./footer.jsp" %>
</body>
<script type="text/javascript">
	setInterval(nowDate, 1000);
	
	function nowDate(){
		const date = new Date();
		document.getElementById("newDate").innerHTML = date.toLocaleString();
	}

</script>
</html>







