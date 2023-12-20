<%@page import="com.koneko.consulting.vo.Student"%>
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
<h3>通过原生的方式获取属性</h3>
<%
Student student = new Student();
%>
学生编号：<%=student.getUserId() %><br>
学生姓名：<%=student.getUserName() %><br>
学生密码：<%=student.getUserPassword() %><br>
学生年龄：<%=student.getUserAge() %><br>
学生性别：<%=student.getUserSex() %><br>
学生生日：<%=student.getUserBirthday() %><br>
<%
%>

<h3>通过EL表达式的方式获取属性</h3>
学生编号：${stu.userId }<br>
学生姓名：${stu.userName }<br>
学生密码：${stu.userPassword }<br>
学生年龄：${stu.userAge }<br>
学生性别：${stu.userSex }<br>
学生生日：${stu.userBirthday }<br>
</body>
</html>