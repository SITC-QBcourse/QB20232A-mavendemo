<%@ page pageEncoding="UTF-8" %>    <%-- 设置显示编码 --%>
<%@ page import="com.koneko.consulting.dbc.DatabaseConnection"%> <%-- 负责数据库的连接 --%>
<%@ page import="java.sql.*" %> <%-- 负责JDBC的开发操作 --%>
<html>
<head>
    <title>www.koneko-consulting.com —— 用户登录案例</title>
</head>
<body>
<%  // 本次直接通过JDBC编写数据库的认证操作
    String name = null; // 保存最终用户的姓名
    String mid = request.getParameter("mid"); // 接收mid的请求参数
    String password = request.getParameter("password"); // 接收password请求参数
    String sql = "SELECT name FROM member WHERE mid=? AND password=?";
    PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql);
    pstmt.setString(1, mid);
    pstmt.setString(2, password);
    ResultSet rs = pstmt.executeQuery(); // 执行数据查询
    if (rs.next()) {    // 有数据返回
        name = rs.getString(1); // 保存姓名
    }
    DatabaseConnection.close(); // 关闭数据库连接
%>
<%
    if (name == null) { // 登录失败，没有查询到name字段
%>      <%-- 如果现在存在有这个参数就表示出错了 --%>
        <jsp:forward page="login.jsp">
            <jsp:param name="error" value="emsg"/>
        </jsp:forward>
<%
    } else {
%>      <%-- 登录成功之后将姓名传递到欢迎页上进行显示 --%>
        <jsp:forward page="welcome.jsp">
            <jsp:param name="name" value="<%=name%>"/>
        </jsp:forward>
<%
    }
%>
</body>
</html>