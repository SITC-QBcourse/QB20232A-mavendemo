<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>【传统型】判断后输出name属性：<%=request.getSession().getAttribute("name") %></h1>
<h1>【改良型】输出session域name属性：${sessionScope.name}</h1>
<h1>【改良型】输出request域name属性：${requestScope.name}</h1>
</body>
</html>