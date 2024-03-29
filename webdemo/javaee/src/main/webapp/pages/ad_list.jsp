<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.koneko.consulting.dbc.DatabaseConnection" %>
<%@ page import="java.sql.*" %>
<%@include file="/pages/plugins/include_basepath.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%
	String addNewsUrl = basePath + "pages/ad_add.jsp" ;
	String editNewsUrl = basePath + "pages/ad_edit.jsp" ;
	String deleteNewsUrl = basePath + "pages/ad_delete_do.jsp" ;
%>
	<jsp:include page="/pages/plugins/include_javascript.jsp" />
<script type="text/javascript" src="js/pages/add_list.js"></script>
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
					<strong><i class="fa fa-archive"></i>&nbsp;首页大幅广告列表</strong>
					<a href="<%=addNewsUrl%>" id="addBtn" class="btn btn-xs btn-primary"><span class="glyphicon glyphicon-plus-sign"></span>&nbsp;发布公告</a>
				</div>
				<div class="panel-body">
					<table class="table table-hover">
						<tr>
							<th width="40%" class="text-center">标题</th>
							<th width="20%" class="text-center">链接地址</th>
							<th width="30%" class="text-center">广告图片</th>
							<th width="10%" class="text-center">操作</th>
						</tr>
						<%
						String sql = "select aid,title,url,photo from ad";
						PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						while(rs.next()){
							long aid = rs.getInt(1);
							String title = rs.getString(2);
							String url = rs.getString(3);
							String photo = rs.getString(4);
							%>
							<tr>
	                          <td class="text-left"><%=title %></td>
	                          <td class="text-left"><%=url %></td>
	                          <td class="text-center"><img alt="<%=title %>" src="upload/ad/<%=photo %>" width="200"></td>
	                          <td class="text-center">
	                           <a href="<%=editNewsUrl %>?aid=<%=aid %>" class="btn btn-xs btn-primary">编辑</a>
	                           <a href="<%=deleteNewsUrl %>?aid=<%=aid %>" class="btn btn-xs btn-danger">删除</a>
	                          </td>
	                        </tr>
							<%
						}
						DatabaseConnection.close();
						%>
						
					</table>
				</div>
				<div class="panel-footer">
					<jsp:include page="plugins/include_foot.jsp"/>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
