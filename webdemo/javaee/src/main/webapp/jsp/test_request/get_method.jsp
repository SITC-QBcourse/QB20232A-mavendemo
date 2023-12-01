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
String method = request.getMethod();
String IP = request.getRemoteAddr();
String sessionID = request.getRequestedSessionId();
String path1 = request.getRequestURL().toString();
String path2 = request.getContextPath();
String path3 = request.getServletPath();
%>
请求方法：<%=method %><br>
请求IP：<%=IP %><br>
sessionID:<%=sessionID %><br>
上下文路径：<%=path2 %><br>
访问路径：<%=path3 %><br>
请求路径：<%=path1 %><br>
总路径：http://<%=request.getHeader("host") %> + <%=path2 %> + <%=path3 %>
</body>
</html>