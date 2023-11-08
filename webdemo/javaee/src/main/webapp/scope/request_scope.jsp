<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Object name = application.getAttribute("name");
String userName = (String)name;
Object time = application.getAttribute("time");
Date dateTime = (Date)time;
%>

姓名：<%=userName %><br>
时间：<%=dateTime %>
</body>
</html>