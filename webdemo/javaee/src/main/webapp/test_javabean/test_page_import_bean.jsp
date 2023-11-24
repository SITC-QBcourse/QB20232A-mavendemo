<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="stu" scope="page" class="com.koneko.consulting.bean.Student"/>
<%
stu.setName("老杨");
stu.setAge(20);
%>
姓名：<jsp:getProperty property="name" name="stu"/><br>
年龄：<jsp:getProperty property="age" name="stu"/><br>
</body>
</html>