<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	Enumeration<String> enu = request.getParameterNames();
%>
<div style="text-align: center;">
    <table border="1" width="50%">
        <tr>
            <th>参数名称</th>
            <th>参数内容</th>
        </tr>
        <%
        while(enu.hasMoreElements()){
            String parameterName = enu.nextElement();
        %>
        <tr>
            <td><%=parameterName %></td>
            <td>
            <%
            if(parameterName.startsWith("**")){
            	String[] parameterValue = request.getParameterValues(parameterName);
            	for(int i = 0; i < parameterValue.length; i++){
            		%>
            		  <%=parameterValue[i] %>
            		  <%="  " %>
            		<%
            	}
            }else{
            	String parameterValue = request.getParameter(parameterName);
            	%>
            	<%=parameterValue %>
            	<%
            }
            %>
            </td>
        </tr>
        <%
        }        
        %>
    </table>
</div>
</body>
</html>