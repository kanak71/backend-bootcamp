<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css:  bootstrap 3.x, sweetalert2,  -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.26.24/dist/sweetalert2.min.css">

<!-- js :  jquery.js, boostrap.js,sweetalert2.js  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.26.24/dist/sweetalert2.all.min.js"></script>

<!-- answerboard.js -->
<script type="text/javascript" src="./js/answerboard.js"></script>

<!-- boostrap css 오버라이딩 -->
<style type="text/css">
	.container{
		width: 800px;
		margin: 50px auto;
		height: 60vh;
		min-height: 500px;
	}
	
	header{
		background: #015939;
		height: 100px;
		color: #000000;
		min-width: 760px;
	}
	
	footer{
		background: #015939;
		text-align: center;
		line-height: 20px;
		padding: 20px;
		color: white;
		clear: both;
	}

</style>
</head>
<body>
	<header>
		<div style="padding:30px;">
			<h3 style="display: inline;">
				<a href="./boardList.do">게시판 구현</a>
			</h3>
			
			<c:choose>
				<c:when test="${loginDto == null }">
					<div style="display: inline; float: right;">
						<button class="btn btn-info" onclick="location.href='./loginServlet.do'">Sign In</button>
						<button class="btn btn-primary">Sign Up</button>
					</div>
				</c:when>
			
				<c:otherwise>
					<div style="display: inline; float: right;">
						<span style="color: white;">
							아이디: ${loginDto.id}(${loginDto.auth eq 'ROLE_ADMIN'? '관리자':'사용자'})
							<button class="btn btn-info">MyPage</button>
							<button class="btn btn-danger" onclick="location.href='./loginServlet.do'">LogOut</button>
						</span>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">WebSiteName</a>
		    </div>
		    <ul class="nav navbar-nav">
		      <li><a href="#">Home</a></li>
		      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">회원관리<span class="caret"></span></a>
		        <ul class="dropdown-menu">
		          <li><a href="#">회원 정보 조회</a></li>
		          <li><a href="#">신고 회원</a></li>
		        </ul>
		      </li>
		      <li><a href="#">게시판</a></li>
		      <li><a href="#">글작성</a></li>
		    </ul>
		  </div>
		</nav>
	
	</header>
</body>
</html>




