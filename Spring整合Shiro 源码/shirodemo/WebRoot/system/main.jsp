<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>main page</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
  	login success,this is main jsp!
  </body>
</html>
