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
long start = session.getCreationTime();
long end = session.getLastAccessedTime();
%>

session创建时间：<%=new Date(start) %>
session最终时间：<%=new Date(end) %>
当前停留时间：<%=end - start %>
</body>
</html>