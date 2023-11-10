<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="response.jsp" method="get">
    请输入姓名：<input type="text" name="name"/><br>
    请输入年龄：<input type="text" name="age"/><br>
    请选择性别：<input type="radio" name="gender" value="男">男
    <input type="radio" name="gender" value="女">女<br>
    请选择城市：<select name="city">
                <option value="葛饰区">葛饰区</option>
                <option value="新宿区">新宿区</option>
                <option value="中野区" selected="selected">中野区</option>
                <option value="丰岛区">丰岛区</option>
                </select><br>
    请选择爱好：<input type="checkbox" name="**inst" value="唱歌">唱歌
    <input type="checkbox" name="**inst" value="跳舞">跳舞
    <input type="checkbox" name="**inst" value="爬山">爬山
    <input type="checkbox" name="**inst" value="大保健">大保健<br>
    请选择爱好：<input type="checkbox" name="**rabby" value="唱歌">唱歌
    <input type="checkbox" name="**rabby" value="跳舞">跳舞
    <input type="checkbox" name="**rabby" value="爬山">爬山
    <input type="checkbox" name="**rabby" value="大保健">大保健<br>
    <input type="hidden" name="hidden" value="123"/><br>
    请输入简介：<textarea name="info" cols="30" rows="5"></textarea><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>