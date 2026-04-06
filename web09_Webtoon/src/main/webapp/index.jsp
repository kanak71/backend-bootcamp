<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처음페이지</title>
</head>
<body>
	<h2>
		<button onclick="location.href='./webtoon.do'">웹툰보기</button>
	</h2>

	<fieldset>
		<legend>웹툰 자동 보기</legend>
		<form action="./webtoon.do" method="get">
			<select name="title">
				<option value="650305">호랑이 형님</option>
				<option value="833255">낢이 사는 이야기</option>
			</select>
			<input type="submit" value="만화보기">
		</form>
	</fieldset>
</body>
</html>