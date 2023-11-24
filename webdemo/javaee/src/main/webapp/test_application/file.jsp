<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
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
String path = this.getServletContext().getRealPath("/log/" + request.getParameter("fname"));
File file = new File(path);
Scanner scan = new Scanner(file);
scan.useDelimiter("\n");
while(scan.hasNext()){
	String str = scan.next();
	out.println(str + "<br>");
}
scan.close();
%>
</body>
</html>