<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>www.koneko-consulting.com</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
</head>
<body class="container">
<%
    String name = request.getParameter("name"); // 传递的name参数
%>
<div class="row">
    <div class="col-md-12">
        <img src="images/logo.png" style="height: 30px;">
        <span class="text-success">登录成功，欢迎<%=name%>访问！</span>
    </div>
</div>
</body>
</html>
