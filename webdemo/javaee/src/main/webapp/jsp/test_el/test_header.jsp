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
<h1>【header标志位】请求主机：${header.host }</h1>
<h1>【header标志位】连接来源：${header.Referer }</h1>
<h1>【header标志位】SessionID：${cookie.JSESSIONID.value }</h1>
</body>
</html>