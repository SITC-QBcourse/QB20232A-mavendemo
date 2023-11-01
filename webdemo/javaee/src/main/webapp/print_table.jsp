<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第一个jsp文件</title>
</head>
<body>
<%
    int rows = 0;
    int cols = 0;  
    try{
        rows = Integer.parseInt(request.getParameter("rows"));
        cols = Integer.parseInt(request.getParameter("cols"));  
    }catch(Exception e){}    
    out.println("这是一个测试文字");
%>
    <table border="1">
<%
    for(int i = 0; i < rows; i++){
%>
        <tr>
<%
        for(int j = 0; j < cols; j++){
%>
            <td width="30" height="30" align="center">
<%      
            out.println(i*j);
%>
            </td>
<%
        }
%>
        </tr>
<%
    }
%>
</table>
</body>
</html>