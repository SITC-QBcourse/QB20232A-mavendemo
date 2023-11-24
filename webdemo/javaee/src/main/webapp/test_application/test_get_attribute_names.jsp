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
Enumeration<String> enu = application.getAttributeNames();
while(enu.hasMoreElements()){
	String name = enu.nextElement();
	out.println("属性名：" + name + "\t属性值：" + application.getAttribute(name) + "<br>");
}
%>
</body>
</html>