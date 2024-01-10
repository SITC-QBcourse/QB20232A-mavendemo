<%@ page pageEncoding="UTF-8" import="java.lang.reflect.*" %>    <%-- 设置显示编码 --%>
<html>
<head>
    <title>(株)コネコ・コンサルティング</title>
</head>
<body>
<%
    Method method = pageContext.getRequest().getClass().getMethod("getMethod"); // 反射获取调用方法
%>
<h1>请求模式：<%=method.invoke(pageContext.getRequest())%></h1>
</body>
</html>