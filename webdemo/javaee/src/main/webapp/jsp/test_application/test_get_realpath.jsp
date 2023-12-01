<%@page import="java.io.File"%>
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

String path1 = application.getRealPath("/");//存在
String path2 = application.getRealPath("/test_application");//不存在
String path3 = application.getServletContext().getRealPath("/");
%>
根路径：<%=path1 %><br>
是否存在：<%=new File(path1).exists() %><br>
项目路径：<%=path2 %><br>
是否存在：<%=new File(path2).exists() %><br>
JSP获取路径：<%=path3 %>
</body>
</html>