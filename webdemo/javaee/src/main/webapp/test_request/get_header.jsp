<%@page import="java.util.Enumeration"%>
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
Enumeration<String> headerNames = request.getHeaderNames();
while(headerNames.hasMoreElements()){
	String name = headerNames.nextElement();
	String value = request.getHeader(name);
	out.println("属性名：" + name + "\t属性值：" + value);
	out.println("<br>");
}
%>
</body>
</html>