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
	String name = "laoyang";
	String age = null;

%>

<jsp:forward page="target_page.jsp">
    <jsp:param value="<%=name %>" name="name"/>
<%--     <jsp:param value="<%=age %>" name="age"/> --%>
</jsp:forward>
</body>
</html>