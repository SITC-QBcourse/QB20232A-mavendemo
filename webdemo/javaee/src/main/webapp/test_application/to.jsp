<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.PrintStream"%>
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
request.setCharacterEncoding("utf-8");
String fileName = request.getParameter("fileName");
String fileContent = request.getParameter("fileContent");
String path = this.getServletContext().getRealPath("/");
String filePath = path + "log";
File file = new File(filePath + File.separator + fileName);
if(!file.getParentFile().exists()){
	file.getParentFile().mkdirs();
}
PrintStream ps = new PrintStream(new FileOutputStream(file));
ps.println(fileContent);
ps.close();
%>
<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
file = new File(filePath);
File[] result = file.listFiles();
%>
<h3>当前访问路径：<%=filePath %></h3>
<table border="1">
    <tr>
        <th>文件名称</th>
        <th>文件大小</th>
        <th>修改日期</th>
    </tr>
<%
for(int i = 0; i < result.length; i++){
	%>
	   <tr>
        <td><a href="file.jsp?fname=<%=result[i].getName()%>"><%=result[i].getName() %></a></td>
        <td><%=result[i].length() %></td>
        <td><%=sdf.format(new java.util.Date(result[i].lastModified())) %></td>
    </tr>
	<%
}
%>
</table>
<%
%>
</body>
</html>