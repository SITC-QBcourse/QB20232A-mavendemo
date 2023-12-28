<%@ page pageEncoding="UTF-8" %>
<%  // 通过request获取相关资源信息，拼凑成完整的访问路径
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
            request.getServerPort() + request.getContextPath() + "/" ;
%>
<html>
<head>
    <title>(株)コネコ・コンサルティング</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="js/koneko.util.js"></script>
    <script type="text/javascript" src="js/login.js"></script>
</head>
<body class="container">
<%!
    public static final String LOGIN_URL = "LoginServlet" ;
%>
<div>&nbsp;</div><div>&nbsp;</div>
<div class="row">
    <h1>出错啦！</h1>
</div>
<%
    String error = (String) request.getAttribute("error") ; // 该参数会由check.jsp传递过来
    if (!(error == null || "".equals(error))) {
%>
<div class="row">
    <div class="col-md-12 col-sm-push-2 ">
        <img src="images/error.png" style="width:50px;">&nbsp;
        <span class="text-danger h3"><%=error%></span>
    </div>
</div>
<%
    }
%>
</body>
</html>
