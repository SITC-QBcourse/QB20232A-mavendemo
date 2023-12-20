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
<h1>【pageContext标志位】上下文路径：${pageContext.request.contextPath }</h1>
<h1>【pageContext标志位】当前访问路径：${pageContext.request.requestURL }</h1>
<h1>【pageContext标志位】用户请求模式：${pageContext.request.method }</h1>
<h1>【pageContext标志位】SessionID：${pageContext.session.id }</h1>
</body>
</html>