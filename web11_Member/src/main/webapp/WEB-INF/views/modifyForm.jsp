<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 폼</title>
<style type="text/css">
	.required-field:required {
        border: 2px solid red;
        outline: none;
    }
    .required-field:required:focus {
        border-color: black;
        box-shadow: 0 0 5px black;
    }
</style>
</head>
<!-- TODO 105 회원 정보 수정 -->
<body>
	<form action="./userModifyServlet.do" method="post">
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>이메일</th>
					<th>비밀번호</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${loginDto.name}</td>
					<td>
						<input class="required-field" required type="email" name="email" value="${userInfo.email}">
					</td>
					<td>
						<input type="password" name="password" placeholder="변경할 비밀번호">
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3" style="text-align: center;">
						<input type="submit" value="수정">
						<input type="reset" value="초기화">
						<input type="button" value="뒤로가기" onclick="history.back()">
					</th>
				</tr>
			</tfoot>
		</table>
	</form>
	<!-- 
		비밀번호 확인, 비밀번호 유효성(정규화), onbeforeunload
	 -->
</body>
</html>