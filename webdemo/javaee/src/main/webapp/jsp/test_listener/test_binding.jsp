<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="com.koneko.consulting.linster.UserAuthenticationListener"%>
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
UserAuthenticationListener listener = new UserAuthenticationListener("www.koneko-consulting.com");
session.setAttribute("name", listener);
try{
	TimeUnit.SECONDS.sleep(5);
}catch(Exception e){}
session.removeAttribute("name");
%>
</body>
</html>