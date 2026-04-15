<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글작성 폼화면</title>
</head>
<%@ include file="./header.jsp" %>
<script type="text/javascript" src="./js/writeForm.js"></script>

<body>
	<div class="container">
		<div>
			<a href="javascript:history.back(-1)" class="btn btn-primary btn-block">뒤로가기</a>
		</div>
		
		<form action="./writeBoard.do" method="post" class="form-horizontal">
			<table class="table table-condensed form-group" style="margin: auto;">
				<tbody>
					<tr class="form-group">
						<td><label class="control-label">아이디:</label></td>
						<td>
							<input type="text" class="form-control" id="id" name="id" readonly="readonly" value="${loginDto.id}">
						</td>
					</tr>
					<tr class="form-group">
						<td><label class="control-label">제목:</label></td>
						<td>
							<input type="text" class="form-control" id="title" name="title">
						</td>
					</tr>
					<tr class="form-group">
						<td><label class="control-label">내용:</label></td>
						<td>
							<textarea rows="5" class="form-control" id="content" name="content"></textarea>
						</td>
					</tr>
					<tr class="form-group">
						<td><label class="control-label">내용:</label></td>
						<td>
							<div id="contentView"></div>
						</td>
					</tr>
					
				</tbody>
				<tfoot>
					<tr class="form-group">
						<td colspan="2" style="text-align: center;">
							<input type="button" class="btn btn-primary active" value="새글입력" onclick="validationForm()">
							<input type="reset" class="btn btn-danger active" value="다시입력">
						
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	
<%@ include file="./footer.jsp"  %>
</body>
</html>