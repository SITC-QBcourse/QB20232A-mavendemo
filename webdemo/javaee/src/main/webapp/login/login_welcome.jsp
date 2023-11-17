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
String name = (String)session.getAttribute("nickname");//set方法的没有执行过 null
if(name != null){
	%>
	   欢迎<%=name %>光临！<br>
	   如果要想推出本系统，请<a href="logout.jsp">点击注销</a>!
	<%	
}else{
	%>
    目前您属于非法登录的状态！<br>
    请先进行<a href="login.jsp">登陆</a>操作，然后浏览本站内容！
 <%
}
%>
</body>
</html>