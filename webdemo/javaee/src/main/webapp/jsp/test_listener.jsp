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
String msg = (String)request.getAttribute("msg");
out.println(msg);
request.setAttribute("msg","javaworld.koneko-consulting.com");
%>
<a href="test_listener/test_request_attribute.jsp">点击</a>
</body>
</html>