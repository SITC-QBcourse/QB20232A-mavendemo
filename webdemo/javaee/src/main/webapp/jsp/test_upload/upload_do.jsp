<%@page import="com.koneko.consulting.util.FileUploadUtil"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!

%>
<%
request.setCharacterEncoding("UTF-8");

FileUploadUtil fuu = new FileUploadUtil(request);
List<String> fileNames = fuu.getUUIDName("pic");
fuu.saveUploadFile("pic", fileNames);
// fuu.clear();
%>

<h1>姓名：<%=fuu.getParameter("name") %></h1>
<h1>角色：<%=Arrays.toString(fuu.getParameterValues("role")) %></h1>
<h1>照片：
<%
for(String fileName : fileNames){
	%>
	   <img src="<%=request.getContextPath() %>/upload/<%=fileName %>"
	<%
}
%></h1>

</body>
</html>