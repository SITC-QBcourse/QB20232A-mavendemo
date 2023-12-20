<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
pageContext.setAttribute("name", "page");
request.setAttribute("name", "reqest");
session.setAttribute("name", "session");
application.setAttribute("name", "application");
%>
<h1>【page】：${pageScope.name }</h1>
<h1>【request】：${requestScope.name }</h1>
<h1>【session】：${sessionScope.name }</h1>
<h1>【application】：${applicationScope.name }</h1>
</body>
</html>