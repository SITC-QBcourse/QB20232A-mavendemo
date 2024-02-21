<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 超链接没有特定规定提交method模式，所有默认的都是get的模式 -->
<a href="${pageContext.request.contextPath}/studentinfo/tmc22012/welcome.action">查询学生信息</a>

<form action="${pageContext.request.contextPath}/rest.do/123" method="post">
    <input type="submit" value="增">
</form>
<form action="${pageContext.request.contextPath}/rest.do/123" method="post">
    <input type="submit" value="删">
    <input type="hidden" name="_method" value="delete">
</form>
<form action="${pageContext.request.contextPath}/rest.do/123" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="改">
</form>
<form action="${pageContext.request.contextPath}/rest.do/123" method="get">
    <input type="submit" value="查">
</form>


<form action="${pageContext.request.contextPath}/getParam.do" method="post">
    <input type="text" name="name">
    <input type="submit" value="删">
    <input type="hidden" name="_method" value="delete">
</form>


<a href="${pageContext.request.contextPath}/modelAndView.do">查询城市信息:ModelAndView</a><br>
<a href="${pageContext.request.contextPath}/modelMap.do">查询城市信息:ModelMap</a><br>
<a href="${pageContext.request.contextPath}/map.do">查询城市信息:Map</a><br>
<a href="${pageContext.request.contextPath}/model.do">查询城市信息:Model</a><br>


<form action="${pageContext.request.contextPath}/selectById.do" method="post">
    请输入需要修改的学生的学号：<input type="text" name="id"><br>
    请输入需要修改的学生的姓名：<input type="text" name="name"><br>
    <input type="submit" value="提交">
</form>
forward:<form action="${pageContext.request.contextPath}/forward.do" method="post">
    <input type="submit" value="跳转">
</form>
redirect:<form action="${pageContext.request.contextPath}/redirect.do" method="post">
    <input type="submit" value="跳转">
</form>
<form action="${pageContext.request.contextPath}/testStudent.do" method="post">
    生日：<input type="text" name="birthday"><input type="submit" value="提交">${requestScope.errorMessage}
</form>
</body>
</html>