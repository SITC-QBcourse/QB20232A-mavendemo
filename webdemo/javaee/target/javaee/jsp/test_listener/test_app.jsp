<%@page import="java.util.concurrent.TimeUnit"%>
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
application.setAttribute("name", "laoyang");
try{
	TimeUnit.SECONDS.sleep(3);
}catch(Exception e){
	
}
application.setAttribute("name", "laoli");
try{
    TimeUnit.SECONDS.sleep(3);
}catch(Exception e){
    
}
application.removeAttribute("name");
%>
</body>
</html>