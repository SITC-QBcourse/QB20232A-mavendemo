<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Request保存的内容：<%=request.getAttribute("name1") %><br>
Session保存的内容：<%=request.getAttribute("name2") %>
</body>
</html>