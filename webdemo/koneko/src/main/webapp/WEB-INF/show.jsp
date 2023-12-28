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
<h1>【Request属性接收】request-msg = <%=request.getAttribute("request-msg")%></h1>
<h1>【Session属性接收】session-msg = <%=session.getAttribute("session-msg")%></h1>
</body>
</html>