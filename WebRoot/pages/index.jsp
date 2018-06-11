<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String username = (String) request.getSession().getAttribute("username");
if(username == null){
	username = "";
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <title>index</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="Idle校园二手商品管理系统！" />
    <meta name="keywords" content="Idle校园二手商品管理系统！" />
    <meta name="Author" content="Idle" />
    <meta name="CopyRight" content="Idle" />
</head>
<frameset rows="84,*"  frameborder="no" border="0" framespacing="0">
    <frame src="<%=path %>/pages/top.jsp?username=<%=username %>" name="top" 
    	noresize="noresize" frameborder="0"  scrolling="no" marginwidth="0" marginheight="0" />
    <frameset cols="185,*">
        <frame src="<%=path %>/pages/left.jsp?username=<%=username %>" name="left" 
        	noresize="noresize" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" />
        <frame src="<%=path %>/pages/main.jsp?username=<%=username %>" name="main" 
        	frameborder="0" scrolling="auto" marginwidth="0" marginheight="0" />
</frameset>
</html>