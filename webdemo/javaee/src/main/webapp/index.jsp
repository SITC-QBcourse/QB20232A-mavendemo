<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.koneko.consulting.dbc.DatabaseConnection" %>
<%@ page import="java.sql.*" %>
<%@include file="/pages/plugins/include_basepath.jsp" %>
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="/pages/plugins/include_javascript.jsp" />
<script type="text/javascript" src="js/index.js"></script>
</head>

<body>
	<div class="container contentback">
		<div id="navbarDiv" class="row">
			<jsp:include page="/pages/plugins/include_navbar.jsp"/>
		</div>
		<div id="splitDiv" class="row">
			<div class="col-md-12" style="height:50px;"></div>
		</div>
		<div id="adDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<div id="carouselMenu" class="carousel slide" data-interval="200" data-wrap="true">
					<!-- 轮播（Carousel）内容显示，显示内容的个数与索引控制项对应 -->
					<div class="carousel-inner">
					<%
						String sql = "select title,url,photo from ad where photo like 'ads%'";
						PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						int index = 0;
						while(rs.next()){
						    String title = rs.getString(1);//数据库中的相片的title alt
						    String url = rs.getString(2);//url 连接地址
						    String photo = rs.getString(3);//photo 文件名  
						    if(!photo.startsWith("ads")){
						    	continue;
						    }
						%>
						<div class="item <%=index++ == 0 ? " active":""%>">
                            <a href="<%=url %>" target="_ablank">
                                <img src="upload/ad/<%=photo %>" alt="<%=title %>">
                            </a>
                        </div>
						<%
						}
					%>
						
					</div>
					<!-- 轮播（Carousel）导航 -->
					<a class="carousel-control left" href="#carouselMenu"
					   data-slide="prev">&lsaquo;</a>		<!-- 显示前一个轮播项内容 -->
					<a class="carousel-control right" href="#carouselMenu"
					   data-slide="next">&rsaquo;</a>		<!-- 显示后一个轮播项内容-->
				</div>
			</div>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
<!-- 			<div class="col-sm-12"> -->
<!-- 				<video width="1140" height="715" controls="controls" autoplay="autoplay" loop="loop"> -->
<!-- 					<source src="images/main.mp4" type="video/mp4"> -->
<!-- 				</video> -->
<!-- 			</div> -->
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$("#carouselMenu").carousel({
		interval : 2000 ,					// 轮播项切换时间为2秒
		wrap : true						// 鼠标经过时暂停显示
	}) ;
</script>