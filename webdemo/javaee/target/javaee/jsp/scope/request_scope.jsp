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
Object name = pageContext.getAttribute("name",pageContext.REQUEST_SCOPE);
String userName = (String)name;
Object time = request.getAttribute("time");
Date dateTime = (Date)time;
%>

姓名：<%=userName %><br>
时间：<%=dateTime %>
</body>
</html>