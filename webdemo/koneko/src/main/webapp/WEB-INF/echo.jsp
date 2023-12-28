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
<div><img src="images/yootk.png"></div>
<h1>【ECHO数据回显】<%=request.getAttribute("message")%></h1>
</body>
</html>