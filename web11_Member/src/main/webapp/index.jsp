<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫페이지, 로그인</title>
<style type ="text/css">

	td{
		border: 1px solid pink;
		padding: 10px;
	}
	
	table{
		border: 2px solid blue;
		border-radius: 5px;
		border-collapse: collapse;
		width: 300px;
		margin: 200px auto;
	}
	
</style>
<script type="text/javascript">
	function regist(){
		location.href="./registServlet.do";
	}
</script>
</head>
<body>
<!-- TODO 100 첫번째 페이지 로그인 / 회원가입 -->
	<form action="./loginServlet.do" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<th colspan="2">
				<!-- TODO 101 로그인 -->
					<input type="submit" value="로그인">
					<input type="button" value="회원가입" onclick="regist()">
				</th>
			</tr>
		</table>
	
	</form>
</body>
</html>