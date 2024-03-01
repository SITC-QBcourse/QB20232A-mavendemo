<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="get" action="${pageContext.request.contextPath}/testForm">
    <input type="submit" value="查询"/>
</form:form>
<form:form method="post" action="${pageContext.request.contextPath}/testForm">
    <input type="submit" value="增加"/>
</form:form>
<form:form method="delete" action="${pageContext.request.contextPath}/testForm">
    <input type="submit" value="删除"/>
</form:form>
<form:form method="put" action="${pageContext.request.contextPath}/testForm">
    <input type="submit" value="修改"/>
</form:form>
</body>
</html>