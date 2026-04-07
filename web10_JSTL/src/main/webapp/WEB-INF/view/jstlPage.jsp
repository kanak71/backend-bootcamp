<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- TODO 006 JSTL 사용을 위한 taglib 선언 -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    <!-- TODO 005  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습</title>
</head>
<body>
	<fieldset>
		<legend>JSTL (Java Standard Tag Library)</legend>
		<div>
			객체의 길이 size: ${lists.size()}<br>
			객체의 길이 length: ${fn:length(lists)}<br>
			객체의 0번째 출력: ${lists[0]}
		</div>
	</fieldset>
	
	<table>
		<thead>
			<tr>
				<td>연번</td>
				<td>이름</td>
				<td>국어</td>
				<td>수학</td>
				<td>영어</td>
				<td>평균</td>
				<td>등급</td>
			</tr>
		</thead>		

	
	<tbody>
		<c:forEach var="d" items="${lists}" varStatus="vs">
			<tr>
				<td>${fn:length(lists) - vs.index} / ${vs.index} ${vs.count} </td>
				<td>
					<c:if test="${d.name eq '홍길동0'}">
						if문
					</c:if>
					<c:choose>
						<c:when test="${d.name eq '홍길동1' }">
							${d.name} 님 반갑습니다
						</c:when>
						<c:when test="${d.name eq '홍길동6'}">
							${d.name} 님 안녕하세요
						</c:when>
						<c:otherwise>
							누구세요?
						</c:otherwise>
					</c:choose>
				</td>
				<td>${d.kor}</td>
				<td>${d.math}</td>
				<td>${d.eng}</td>
				
				<c:set var="total" value="${d.kor + d.math + d.eng }"/>
				<td>${total}</td>
				<td>${total/3}</td>
				<td>${total > 70 ? "합격" :"과락" }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- for문 향상된 for, index for 
		for(int i=0; i<10; i++)-->
	<fieldset>
		<legend>for(index for), end 값을 포함한다</legend>
		<div>
			<c:forEach var="i" begin="0" end="9" step="1">
			2 x ${i} = ${i*2} <br>
			</c:forEach>
			
		</div>
	</fieldset>
	
	<fieldset>
		<legend>formating(형변환)</legend>
		<p>
			형변환 날짜 형태가 String 이거나, java.util.Data 타입으로 되어 있다면 이를 변환 가능하다 &lt;c:fmt
		</p>
		<p>
			<!-- DTO의  값이 java.util.Date로 되어 있을 때 -->
			<b>format ~~ 문자열로 출력하겠다. pattern 모양대로</b>
			<fmt:formatDate value="<%=new Date() %>" pattern="yyyy년도 MM월 dd일 HH:mm:ss"/>
		</p>
		<p>
			<!-- 모양이 맞아야 한다 2026-04-10 10:41:30 = pattern yyyy-MM-dd HH:mm:ss -->
			<!-- 날짜형 문자는 java.util.Date로 변경하고 pattern에 맞춰서 출력 -->
			<b>parse~~ 특정 타입으로 변경하겠다</b>
			<fmt:parseDate var="convertDate" value="2026-04-10 10:41:30" pattern="yyyy-MM-dd HH:mm:ss"/>
			<fmt:formatDate value="${convertDate}" pattern="yyyy년 MM월 dd일"/>
		</p>
	</fieldset>
	
	<!-- 
		JSTL : java의 문법을 HTML에 Editor에서 쉽게 작성 할 수 있도록 만들어 놓은 Tag이다
		EL : Expression Language
			 - 값을 바인딩 할 때 사용한다 ex) myBatis에서 xml에 properties 값을 입력할때 
	 -->
	 <div>
	 	서버로부터 전송 받은 값을 출력 : <br>
	 	requset.setAttribute("lists", lists); 출력<br>
	 	${request.lists}
	 	<br>
	 	${param.query}
	 </div>

</body>
</html>





