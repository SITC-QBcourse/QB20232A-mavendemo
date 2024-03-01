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
<form:form modelAttribute="person" action="${pageContext.request.contextPath}/testcheckbox.do">
    性别：<form:checkbox  path="gender"/><br>
<%--     爱好：<form:checkbox path="inst" value="football"/>足球 --%>
<%--     <form:checkbox path="inst" value="basketball"/>篮球 --%>
<%--     <form:checkbox path="inst" value="pingpang"/>乒乓球<br> --%>
    爱好：<form:checkboxes  items="${balls}" path="insts"/><br>
    <input type="submit" value="提交"/>
</form:form>
</body>
</html>