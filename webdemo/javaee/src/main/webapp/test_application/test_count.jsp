<%@page import="java.util.concurrent.locks.ReentrantLock"%>
<%@page import="java.util.concurrent.locks.Lock"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.PrintStream"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
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
//保存增加量，写文件
public void save(File file, BigInteger num) throws Exception{
	Lock lock = new ReentrantLock();//互斥锁
	lock.lock();
	try{
		PrintStream ps = new PrintStream(new FileOutputStream(file));
	    ps.print(num);
	    ps.close();
	}catch(Exception e){
		throw e;
	}
	this.getServletContext().setAttribute("count",num);
	lock.unlock();
}
//读取保存文件
public BigInteger load(File file) throws Exception{
	if(this.getServletContext().getAttribute("count") == null){
		if(file.exists()){
			Scanner scan = new Scanner(file);
			if(scan.hasNext()){
				BigInteger i = new BigInteger(scan.next());
				this.getServletContext().setAttribute("count",i);
			}
		}
	}
	String temp = String.valueOf(this.getServletContext().getAttribute("count"));
	return new BigInteger(temp);
}
%>
<%
String fileName = this.getServletContext().getRealPath("/") + "count.txt";
File file = new File(fileName);
BigInteger i = load(file);
if(session.isNew()){
	i = i.add(new BigInteger("1"));
	save(file, i);
}else{
	session.invalidate();
	i = i.add(new BigInteger("1"));
    save(file, i);
}
%>
您是第<%=i %>位访客！
</body>
</html>