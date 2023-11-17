<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//.JSESSIONID=5914210272F56F33B7C0986627A96583

Cookie[] cs = request.getCookies();
System.out.println(Arrays.toString(cs));
%>
</body>
</html>