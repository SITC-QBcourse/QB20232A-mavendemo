<%@ page pageEncoding="UTF-8" import="java.util.*" %>
<%@ page import="com.koneko.consulting.common.util.ParameterUtil" %>    <%-- 导入自定义的工具类 --%>
<html>
<head>
    <title>(株)コネコ・コンサルティング——www.koneko-consulting.com</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8"); // 请求编码配置
    ParameterUtil pu = new ParameterUtil(request); // 通过HttpServletRequest实现上传处理
    List<String> fileNames = pu.getUUIDName("photo"); // 生成最终存储的文件名称集合
    pu.saveUploadFile("photo", fileNames); // 文件存储
    pu.clean();// 清空临时目录中的保存文件内容
%>
<h1>姓名：<%=pu.getParameter("name")%></h1>
<h1>角色：<%=Arrays.toString(pu.getParameterValues("role"))%></h1>
<%
    for (String fileName : fileNames) {
%>
        <img src="<%=request.getContextPath()%>/upload/<%=fileName%>">
<%
    }
%>
</body>
</html>