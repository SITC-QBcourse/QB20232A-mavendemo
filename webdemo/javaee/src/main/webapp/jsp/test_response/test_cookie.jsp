<%@page import="java.net.CookieHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Cookie cookie1 = new Cookie("tea","laoyang");
Cookie cookie2 = new Cookie("stu","menglingru");
cookie1.setMaxAge(30);
cookie2.setMaxAge(3);
response.addCookie(cookie1);
response.addCookie(cookie2);
%>
</body>
</html>