<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.*"%>
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
String urlString = request.getParameter("down");
String target = request.getParameter("target");
try{
	URL url = new URL(urlString);     
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	InputStream in = connection.getInputStream();
	PrintStream output = new PrintStream(new File("c:\\laoyang\\io\\" + target + ".jpg"));
	long content = in.transferTo(output);
	if(content > 0){
	    %>
	       <jsp:forward page="success.jsp"/>
	    <%
	}else{
	    %>
	       <jsp:forward page="failure.jsp"/>
	    <%
	}
}catch(Exception e){
%>
           <jsp:forward page="failure.jsp"/>
        <%
}
%>
</body>
</html>