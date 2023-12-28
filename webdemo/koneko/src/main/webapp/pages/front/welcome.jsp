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
                <div class="col-sm-12 text-center"><img src="../../images/logo.png" style="width: 400px;"></div>
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
                <img src="images/logo.png" style="height: 30px;">
                <strong>沐言科技（www.yootk.com） —— 新时代软件教育领导品牌</strong>
            </div>
        </div>
    </div>
</body>
</html>
