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
int buffer = out.getBufferSize();
int unused = out.getRemaining();
int used = buffer - unused;
%>

缓冲区大小：<%=buffer %><br>
未使用大小：<%=unused %><br>
已使用大小：<%=used %>
</body>
</html>