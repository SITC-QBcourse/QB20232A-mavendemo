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
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="stu" class="com.koneko.consulting.bean.Student"/>
<jsp:setProperty property="*" name="stu"/>

姓名：<jsp:getProperty property="name" name="stu"/><br>
年龄：<jsp:getProperty property="age" name="stu"/>
</body>
</html>