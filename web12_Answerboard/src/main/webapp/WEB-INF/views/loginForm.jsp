<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	body{
	height: 100vh;
	background: #f8f8f8;
	}
	
	.login-box{
		width: 400px;
		padding: 30px;
		background: white;
		border-radius: 10px;
		box-shadow: 0 4px 12px rgba(0, 0, 0 .1);
	}

</style>
</head>
<body class="d-flex align-items-center justify-content-center">
	<form class="login-box" action ="./loginServlet.do" method="post">
		<h3 class="text-center mb-4 fw-bold">로그인</h3>
		<div class="mb-3">
			<label class="form-label">Username</label>
				<input type="text" class="form-control" name="id" placeholder="아이디 입력" value="user03" required="required">
				
		</div>
		
		<div>
		<label class="form-label">Password</label>
				<input type="password" class="form-control" name="pw" placeholder="비밀번호 입력" value="1111" required="required">
		</div>
		
		<div class="d-grid">
			<input type="submit" class="btn btn-primary" value="Login">
			
		</div>
	
	
	</form>
	
</body>
</html>