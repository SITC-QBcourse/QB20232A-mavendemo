<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
pageContext.setAttribute("name","laoyang",pageContext.REQUEST_SCOPE);
pageContext.setAttribute("time",new Date());
%>
<jsp:forward page="request_scope.jsp"/>
<!-- <a href="request_scope.jsp">点击跳转</a> -->
</body>
</html>