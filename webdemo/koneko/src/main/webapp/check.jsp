<%@page import="com.koneko.consulting.dbc.DatabaseConnection"%>
<%@page import="java.sql.*"%>
<%@ page pageEncoding="UTF-8" %>    <%-- 设置显示编码 --%>
<html>
<head>
    <title>www.koneko-consulting.com —— 用户登录案例</title>
</head>
<body>
<%
String name = null;
String mid = request.getParameter("mid");
String password = request.getParameter("password");
String sql = "select name from member where mid = ? and password = ?";
PreparedStatement ps = DatabaseConnection.getConnection("qb2023").prepareStatement(sql);
ps.setString(1, mid);
ps.setString(2, password);
ResultSet rs = ps.executeQuery();
if(rs.next()){
	name = rs.getString(1);
}
DatabaseConnection.close();
%>
<%
if(name == null){
	%>
	   <jsp:forward page="login.jsp">
	       <jsp:param value="emsg" name="error"/>
	   </jsp:forward>
	<%
}else{
	%>
	   <jsp:forward page="welcome.jsp">
	       <jsp:param value="<%=name %>" name="name"/>
	   </jsp:forward>
	<%
}
%>
</body>
</html>