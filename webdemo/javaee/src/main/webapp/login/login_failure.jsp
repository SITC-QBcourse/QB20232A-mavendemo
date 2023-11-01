<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>登陆失败</h1>
<h2>对不起<font color="blue"><%=request.getParameter("error") %></font>还不是本公司的嘉宾！</h2>
<h3>请返回<a href="login.jsp">登陆页面</a>重新登陆</h3>
</body>
</html>