<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입화면form</title>
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

<script type="text/javascript" src="./js/regist.js"></script>
</head>
<!-- TODO 107 회원 가입 화면 -->
<body>
	<h3>회원가입</h3>
	<form action="./registServlet.do" method="post">
		<table>
			<tbody>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" title='n' class="required-field" required>
						<input type="button" value="중복체크" onclick="idCheck()">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="text" name="password" class="required-field" required>
					</td>
				</tr>
				<tr>
					<th>성명</th>
					<td>
						<input type="text" name="name" class="required-field" required>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="email" name="email" class="required-field" required>
						<input type="button" value="이메일확인" onclick="emailCheck()">
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2">
						<input type="submit" value="회원가입">
						<input type="reset" value="초기화">
					</th>
				</tr>
			</tfoot>
		</table>
	</form>

</body>
</html>