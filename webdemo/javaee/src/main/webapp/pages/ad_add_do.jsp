<%@page import="com.koneko.consulting.dbc.DatabaseConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.koneko.consulting.util.ParameterUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/pages/plugins/include_basepath.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<%
	String addNewsUrl = basePath + "pages/ad_add_do.jsp" ;
%>
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
					   request.setCharacterEncoding("UTF-8");
					   ParameterUtil pu = new ParameterUtil(request,"/upload/ad/");
					   List<String> fileNames = pu.getUUIDName("pic");
					   pu.saveUploadFile("pic", fileNames);//upload/ad
					   pu.clean();//temp清空
					   String title = pu.getParameter("title");
					   String url = pu.getParameter("url");
					   String note = pu.getParameter("note");
					   String sql = "insert into ad(title, url, photo, note) value (?,?,?,?)";
					   PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
					   ps.setString(1, title);
					   ps.setString(2, url);
					   ps.setString(3, fileNames.get(0));
					   ps.setString(4, note);
					   int result = ps.executeUpdate();
					   DatabaseConnection.close();
					   if(result > 0){
						   %>
						      <h1>广告项增加成功！</h1>
						   <%
					   }else{
						   %>
						      <H1>广告项增加失败！</H1>
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
