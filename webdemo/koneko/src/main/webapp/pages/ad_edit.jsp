<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.koneko.consulting.dbc.DatabaseConnection" %>
<%@ page import="java.sql.*" %>
<%@include file="/pages/plugins/include_basepath.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<%
		String editUrl = basePath + "pages/ad_edit_do.jsp" ;
	%>
	<jsp:include page="/pages/plugins/include_javascript.jsp" />
	<script type="text/javascript" src="js/pages/ad_edit.js"></script>
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
				<strong><i class="fa fa-file-picture-o"></i>&nbsp;修改广告项</strong>
			</div>
			<div class="panel-body">
				<%
					long aid = Long.parseLong(request.getParameter("aid")); // 接收请求的ID
					String sql = "SELECT title,url,photo,note FROM ad WHERE aid=?";
					PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql);
					pstmt.setLong(1, aid);
					ResultSet rs = pstmt.executeQuery(); // 数据库查询
					if (rs.next()) {
						String title = rs.getString(1);
						String url = rs.getString(2);
						String photo = rs.getString(3);
						String note = rs.getString(4);
				%>
				<form action="<%=editUrl%>" id="myform" method="post" class="form-horizontal" enctype="multipart/form-data">
					<div class="form-group" id="titleDiv">
						<label class="col-md-2 control-label" for="title">标题：</label>
						<div class="col-md-5">
							<input type="text" name="title" id="title" value="<%=title%>" class="form-control input-sm" placeholder="请输入标题">
						</div>
						<div class="col-md-4" id="titleMsg">*</div>
					</div>
					<div class="form-group" id="urlDiv">
						<label class="col-md-2 control-label" for="title">链接：</label>
						<div class="col-md-5">
							<input type="text" name="url" id="url" value="<%=url%>" class="form-control input-sm" placeholder="请输入广告链接路径">
						</div>
						<div class="col-md-4" id="urlMsg">*</div>
					</div>
					<div class="form-group" id="picDiv">
						<label class="col-md-2 control-label" for="pic">图片：</label>
						<div class="col-md-5">
							<input type="file" name="pic" id="pic" class="form-control input-sm" placeholder="请选择发布的图片">
						</div>
						<div class="col-md-4" id="picMsg">*</div>
					</div>
					<div class="form-group" id="noteDiv">
						<label class="col-md-2 control-label" for="note">备注：</label>
						<div class="col-md-9">
							<textarea id="note" name="note" class="form-control" rows="10"><%=note%></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-2 col-md-5">
							<input type="hidden" name="aid" value="<%=aid%>">
							<input type="hidden" name="photo" value="<%=photo%>">
							<input type="submit" value="编辑" class="btn btn-sm btn-primary">
							<input type="reset" value="重置" class="btn btn-sm btn-warning">
						</div>
					</div>
				</form>
				<%
					}
					DatabaseConnection.close();
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
