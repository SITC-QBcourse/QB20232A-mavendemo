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
    <form action="<%=LOGIN_URL%>" class="form-horizontal" id="memberform" method="post">
        <fieldset>
            <legend><img src="images/user-title.png" style="width:50px;">用户登录</legend>
        </fieldset>
        <div class="form-group" id="useridDiv">
            <label class="col-md-2 control-label">用户名：</label>
            <div class="col-md-5">
                <input type="text" id="userid" name="userid" class="form-control" placeholder="请输入用户的注册ID编号。">
            </div>
            <div class="col-md-3">
                <span id="useridSpan"></span>
            </div>
        </div>
        <div class="form-group" id="passwordDiv">
            <label class="col-md-2 control-label">登录密码：</label>
            <div class="col-md-5">
                <input type="password" id="password" name="password" class="form-control" placeholder="请输入登录密码。">
            </div>
            <div class="col-md-3">
                <span id="passwordSpan"></span>
            </div>
        </div>
        <div class="form-group" id="controlDiv">
            <div class="col-md-push-3 col-md-3">
                <button type="submit" class="btn btn-primary btn-sm">登录</button>
                <button type="reset" class="btn btn-warning btn-sm">重置</button>
            </div>
        </div>
    </form>
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
<h1><%=application.getAttribute("online")%></h1>
</body>
</html>
