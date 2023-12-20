<%@page import="com.koneko.consulting.linster.SessionStoreListener"%>
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
SessionStoreListener listener = new SessionStoreListener("www.koneko-consulting.com");
session.setAttribute("user", listener);
%>
</body>
</html>