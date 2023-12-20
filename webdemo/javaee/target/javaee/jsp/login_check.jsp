<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.koneko.consulting.dbc.DatabaseConnection"%>
<%@page import="java.sql.Statement"%>
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
	String password = "123456";
	
	String userName = request.getParameter("name");
	String userPWD = request.getParameter("password");
	
	String code = request.getParameter("code");
	String rand = session.getAttribute("rand").toString();
	
	if(code.equalsIgnoreCase(rand)){
		System.out.println(code);
		System.out.println(rand);
	boolean flag = name.equals(userName)&&password.equals(userPWD);
	if(flag){
		session.setAttribute("nickname",userName);
		response.setHeader("refresh","3;url=./login/login_welcome.jsp");
%>
用户登陆成功！3秒后页面跳转，如果没有自动跳转，请<a href="./login/login_welcome.jsp">点击此处</a>手动跳转！
<%
    }else{
    	response.setHeader("refresh","3;url=login.jsp");
%>
用户登陆失败！（错误的用户名或者密码）<br>
3秒后页面跳转，如果没有自动跳转，请<a href="login.jsp">点击此处</a>手动跳转！
<%
    }
	}else{
		%>
		<jsp:forward page="login.jsp"/>
		<%
	}
%>
</body>
</html>