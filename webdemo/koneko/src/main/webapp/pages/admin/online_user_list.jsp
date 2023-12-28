<%@ page pageEncoding="UTF-8" import="java.util.*" %>
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
</head>
<%!
    public static final String KICKOUT_URL = "KickoutServlet";
%>
<body class="container">
<div class="row">
    <div class="panel panel-success">
        <div class="panel-heading">
            <strong><i class="fa fa-archive"></i>&nbsp;在线用户列表</strong>
        </div>
        <div class="panel-body">
            <%  // 获取当前全部的用户信息
                Map<String, Boolean> onlineMap = (Map<String, Boolean>) application.getAttribute("online"); // 获取Map集合
            %>
            <table class="table table-hover">
                <tr>
                    <th width="40%" class="text-center">用户名</th>
                    <th width="20%" class="text-center">状态</th>
                    <th width="10%" class="text-center">操作</th>
                </tr>
                <%
                    for (Map.Entry<String, Boolean> entry : onlineMap.entrySet()) {
                %>
                <tr>
                    <td class="text-center"><%=entry.getKey()%></td>
                    <td class="text-center">
                    <%
                        if (entry.getValue()) {
                    %>
                        <span class="label label-default">剔除</span>
                    <%
                        } else {
                    %>
                        <span class="label label-success">在线</span>
                    <%
                        }
                    %>
                    </td>
                    <td class="text-center">
                        <a class="btn btn-xs btn-danger" href="<%=KICKOUT_URL%>?userid=<%=entry.getKey()%>">
                            <span class="glyphicon glyphicon-remove"></span>&nbsp;强制下线</a></td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
        <div class="panel-footer">
            <div style="text-align:right;">
                <img src="images/logo.png" style="height: 30px;">
                <strong>(株)コネコ・コンサルティング——www.koneko-consulting.com</strong>
            </div>
        </div>
    </div>
</div>
</body>
</html>
