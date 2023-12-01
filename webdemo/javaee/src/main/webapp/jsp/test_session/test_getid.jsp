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
String sessionID = session.getId();
%>
原始SessionID:<%=sessionID %><br>
变更SessionID:<%=request.changeSessionId() %><br>

</body>
</html>