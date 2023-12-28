<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>(株)コネコ・コンサルティング</title>
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../../bootstrap/css/bootstrap.min.css" />
</head>
<body class="container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <strong><i class="fa fa-archive"></i>&nbsp;用户登录成功</strong>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-sm-12 text-center"><img src="../../images/welcome.gif" style="width: 400px;"></div>
            </div>
            <div>&nbsp;</div><div>&nbsp;</div>
            <div class="row">
                <div class="col-sm-12 text-center">
                    <span class="text-primary" style="font-size: 25px;">
                        用户登录成功，欢迎“<%=session.getAttribute("userid")%>”用户访问！
                    </span>
                </div>
            </div>
        </div>
        <div class="panel-footer">
            <div style="text-align:right;">
                <img src="../../images/logo.png" style="height: 30px;">
                <strong>(株)コネコ・コンサルティング——www.koneko-consulting.com</strong>
            </div>
        </div>
    </div>
</body>
</html>
