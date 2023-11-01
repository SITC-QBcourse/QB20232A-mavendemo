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
	String name = null;
	String mid = request.getParameter("mid");
	String password = request.getParameter("password");    
    String sql = "select name from member where mid= ? and password = ?";
    PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
    ps.setString(1, mid);
    ps.setString(2, password);
    ResultSet rs = ps.executeQuery();
    if(rs.next()){
    	name = rs.getString(1);
    }
    DatabaseConnection.close();
%>
<%
	if(name != null){
%>
    <jsp:forward page="login_welcome.jsp">
        <jsp:param value="<%=name %>" name="name"/>
    </jsp:forward>
<%
	}else{
%>
    <jsp:forward page="login_failure.jsp">
        <jsp:param value="<%=mid %>" name="error"/>
    </jsp:forward>
<%
	}
%>
</body>
</html>