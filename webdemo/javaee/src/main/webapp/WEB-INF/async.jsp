<%@ page pageEncoding="UTF-8" %>    <%-- 设置显示编码 --%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <title>(株)コネコ・コンサルティング</title>
    <base href="<%=basePath%>">
</head>
<body>
<form action="async.input" method="post">
    信息：<input type="text" name="info" value="www.yootk.com"/>
    <button type="submit">提交</button>
</form>
</body>
</html>