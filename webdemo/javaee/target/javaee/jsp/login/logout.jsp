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
session.invalidate();//注销
response.setHeader("refresh","3;url=login.jsp");
%>
您已经成功注销！3秒后页面跳转，如果没有自动跳转，请<a href="login.jsp">点击此处</a>手动跳转！
</body>
</html>