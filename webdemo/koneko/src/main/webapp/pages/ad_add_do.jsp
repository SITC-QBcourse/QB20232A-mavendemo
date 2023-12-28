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
					<strong><i class="fa fa-file-picture-o"></i>&nbsp;增加广告项</strong>
				</div>
				<div class="panel-body">
				<%
					request.setCharacterEncoding("UTF-8"); // 设置请求编码
					ParameterUtil pu = new ParameterUtil(request, "/upload/ad/"); // 广告的图片是有存储路径的
					// 通过ParameterUtil工具组件获取用户所提交的请求参数
					List<String> fileNames = pu.getUUIDName("pic"); // 获取上传的文件内容
					pu.saveUploadFile("pic", fileNames); // 实现了上传文件的存储
					pu.clean(); // 清空临时目录
					String title = pu.getParameter("title");
					String url = pu.getParameter("url");
					String note = pu.getParameter("note");
					String sql = "INSERT INTO ad (title,url,photo,note) VALUES (?,?,?,?)";
					PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql);
					pstmt.setString(1, title);
					pstmt.setString(2, url);
					pstmt.setString(3, fileNames.get(0)); // 文件的图片名称是通过程序计算得来的
					pstmt.setString(4, note);
					out.println(note);
					int result = pstmt.executeUpdate(); // 执行数据更新处理
					DatabaseConnection.close(); // 关闭数据库连接
					if (result > 0) {
				%>
						<h1>广告项增加成功！</h1>
				<%
					} else {
				%>
						<h1>广告项增加失败！</h1>
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
