<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만화보기</title>
<style type="text/css">
	br{
		margin: 0px;
	}
	
	img{
		width: 500px;
		height: auto;
		margin: -4px;
		margin-bottom:0px;
		}

</style>
</head>
<body>
<%
	Object obj = request.getAttribute("wList");
	List<Object> wList = (List<Object>)obj;
	
	for(Object img : wList){
		%>
			<%=img%><br>
		<%
	}
%>

</body>
</html>