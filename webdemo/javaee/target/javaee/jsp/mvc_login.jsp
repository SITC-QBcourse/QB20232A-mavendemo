<%@page import="java.util.*"%>
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
List<String> list = (List<String>)request.getAttribute("info");
// List<String> list = new ArrayList<>();
if(list != null){
	Iterator<String> it = list.iterator();
	while(it.hasNext()){
		out.println(it.next());
	}
}
%>
<form action="/javaee/loginServlet" method="post">
    用户名：<input type="text" name="name"><br>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>