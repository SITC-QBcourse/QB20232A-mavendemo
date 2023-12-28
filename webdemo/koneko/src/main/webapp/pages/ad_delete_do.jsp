<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.koneko.consulting.dbc.DatabaseConnection" %>
<%@ page import="com.koneko.consulting.common.util.ParameterUtil" %>
<%@ page import="java.sql.*" %>
<%@include file="/pages/plugins/include_basepath.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="/pages/plugins/include_javascript.jsp" />
<script type="text/javascript" src="js/pages/ad_add.js"></script>
<script type="text/javascript" src="bootstrap/tinymce/tinymce.min.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div id="navbarDiv" class="row">
		<jsp:include page="/pages/plugins/include_navbar.jsp"/>
	</div>
	<div style="height: 50px;">&nbsp;</div>
	<div class="wrapper">
		<div class="content-wrapper">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><i class="fa fa-file-picture-o"></i>&nbsp;删除广告项</strong>
				</div>
				<div class="panel-body">
				<%
					request.setCharacterEncoding("UTF-8"); // 设置请求编码
					ParameterUtil pu = new ParameterUtil(request, "/upload/ad/"); // 广告的图片是有存储路径的
					long aid = Long.parseLong(pu.getParameter("aid")); // 接收删除id
					String photo = pu.getParameter("photo"); // 原始的图片名称

					String sql = "DELETE FROM ad WHERE aid=?";
					PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql);
					pstmt.setLong(1, aid);
					int result = pstmt.executeUpdate(); // 执行数据更新处理
					DatabaseConnection.close(); // 关闭数据库连接
					if (result > 0) {
						java.io.File file = new java.io.File(this.getServletContext().getRealPath("/upload/ad/"),photo);
						if (file.exists()) {
							file.delete(); // 文件删除
						}
				%>
						<h1>广告项删除成功！</h1>
				<%
					} else {
				%>
						<h1>广告项删除失败！</h1>
				<%
					}
				%>
				</div>
				<div class="panel-footer">
					<jsp:include page="plugins/include_foot.jsp"/>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
