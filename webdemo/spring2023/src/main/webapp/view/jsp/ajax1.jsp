<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
</script>
<script>
$(document).ready(function(){
	$('#testJson').click(function(){
	    $.ajax({
	        type:'post',
	        url:'${pageContext.request.contextPath}/echo.action',
	        data:{
		        'id':$('#id').val()
	        },
	        async:false,
	        dateType:'json',
	        success:function(data){//data = list
		        let stu = data;
		        $('#id').val(stu.id);
		        $('#name').val(stu.name);
		        $('#age').val(stu.age);
		        $('#birthday').val(stu.birthday);
		    },
		    error:function(data){
			    alert('获取失败','错误页面');
			}
	    });
	});
});
</script>
学号：<input type="text" name="id" id="id" value="1"><br>
姓名：<input type="text" name="name" id="name" value=""><br>
年龄：<input type="text" name="age" id="age" value=""><br>
生日：<input type="text" name="birthday" id="birthday" value=""><br>
<input type="button" value="提交" id="testJson">
</body>
</html>