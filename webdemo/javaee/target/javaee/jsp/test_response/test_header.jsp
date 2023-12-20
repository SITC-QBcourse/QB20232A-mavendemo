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
Enumeration<String> enu = request.getHeaderNames();//获取所有的信息头属性名
while(enu.hasMoreElements()){
	String headName = enu.nextElement();//获取每一个属性名
%>
    属性名：<%=headName %> = 属性值：<%=request.getHeader(headName) %><br>    
<%
}
%>
</body>
</html>