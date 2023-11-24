<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
public static final long MAX_SIZE = 3141592L;
public static final long FILE_MAX_SIZE = 1010101L;
public static final String TEMP_DIR = "/temp/";
public static final String UPLOAD_DIR = "/upload/";
public static final String ENCODING = "utf-8";
%>
<%
request.setCharacterEncoding(ENCODING);
DiskFileItemFactory factory = new DiskFileItemFactory();
factory.setRepository(new File(TEMP_DIR));
ServletFileUpload upload = new ServletFileUpload(factory);
upload.setSizeMax(MAX_SIZE);
upload.setFileSizeMax(FILE_MAX_SIZE);

if(upload)
%>
</body>
</html>