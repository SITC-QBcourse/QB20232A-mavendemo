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
application.setInitParameter("demo","test");
Enumeration<String> enu = application.getInitParameterNames();
while(enu.hasMoreElements()){
	String name = enu.nextElement();
	out.println("参数名：" + name + "\t参数值：" + application.getInitParameter(name) + "<br>");
}
%>
</body>
</html>