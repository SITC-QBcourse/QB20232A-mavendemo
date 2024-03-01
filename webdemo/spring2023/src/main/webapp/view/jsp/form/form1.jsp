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
<form:form modelAttribute="person">
    name:<form:input path="name"/><br>
    age:<form:input path="age"/><br>
    <input type="submit" value="提交"/>
</form:form>
</body>
</html>