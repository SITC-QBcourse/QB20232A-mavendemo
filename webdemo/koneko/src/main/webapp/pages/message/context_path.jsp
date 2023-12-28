<%@ page pageEncoding="UTF-8" %>    <%-- 设置显示编码 --%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    out.print(basePath);
%>
<html>
<head>
    <title>(株)コネコ・コンサルティング</title>
    <base href="<%=basePath%>">
</head>
<body>
<div><img src="images/logo.png"></div>
</body>
</html>