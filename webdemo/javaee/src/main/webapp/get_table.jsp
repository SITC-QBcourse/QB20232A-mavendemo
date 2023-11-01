<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="print_table.jsp" method="post">
        请输入要显示的行数：<input type="text" name="rows"><br>
        请输入要显示的列数：<input type="text" name="cols"><br>
        <input type="submit" value="显示">
    </form>
</body>
</html>