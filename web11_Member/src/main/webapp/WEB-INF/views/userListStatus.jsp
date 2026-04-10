<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 전체조회(가능)</title>
</head>
<!-- TODO 111 사용자 권한 변경 -->
<body>
	<%@ include file="Header.jsp"%>
	<hr>
	
	<h2>회원 권한 수정</h2>
	<table class="member-table">

		<thead>
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>이메일</th>
				<th>권한</th>
				<th>상태</th>
				<th>권한변경</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="member" items="${lists}">
				<tr>
					<td>${member.id}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td>${member.auth eq 'ROLE_USER' ? '사용자':'관리자'}</td>
					<td><c:choose>
							<c:when test="${member.enable eq 'Y'}">사용중</c:when>
							<c:otherwise>탈퇴</c:otherwise>
						</c:choose></td>
						
						<!-- TODO 112 권한 변경 이벤트 버튼-->
					<td>
						<!-- HTML에서 값을 argument로 처리할 때는 문자는 ''안에 있어야 한다 
							숫자인 경우는 그냥 사용하거나 ''하셔도 문제 되지 않는다 
						-->
						<button onclick="changeAuth(event, '${member.id}')">권한변경</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>

		<tfoot>
			<tr>
				<th colspan="6">
					<button onclick="history.back()">뒤로가기</button>
				</th>
			</tr>
		</tfoot>

	</table>
	
	<script type="text/javascript">
		function changeAuth(event, id){
			fetch("./authUpdateServlet.do", {
				method:"POST",
				headers: {'Content-Type':'application/x-www-form-urlencoded'},
				body: 'id='+ encodeURIComponent(id)
			})
				.then(res => res.json())
				.then(data => {
					console.log(data.success);
					if(data.success){
						//DOM 탐색을 통해서 변경된 성공의 값을 화면을 변경해 준다 useState(react에서는)
						var btn = event.target;
						var row = btn.parentNode.parentNode;	// 부모TR
						row.cells[3].innerHTML = data.newAuth === 'ROLE_ADMIN' ? '관리자':'사용자';
						alert("권한 변경 성공")
					}else{
						alert("권한 변경 실패")
					}
				})
				.catch(err=>console.log(err));
		}
	</script>
	
	
	
</body>
</html>




