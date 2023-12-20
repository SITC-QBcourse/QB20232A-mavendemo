<%@page import="java.io.PrintWriter"%>
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
out.println("【out】我是通过out输出的");
out.println("<br>");
PrintWriter print = response.getWriter();
print.println("【print】我是通过response.getWriter的返回值对象输出的");
print.println("<br>");
response.getWriter().println("【response.getWriter()】我是通过response.getWriter()方法直接输出的");
response.getWriter().println("<br>");
%>
</body>
</html>