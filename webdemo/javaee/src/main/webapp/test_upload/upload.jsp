<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="upload_do.jsp" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="name"><br>
    角色：<input ytpe="checkbox" name="role" value="admin">管理员
    <input ytpe="checkbox" name="role" value="guest">访客
    <input ytpe="checkbox" name="role" value="ano">陌生人<br>
    照片：<input type="file" name="pic"><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>