<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>shirodemo register page</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
    <form action="<%=basePath%>/user/register" method="post">
    <ul>
    	<li>姓　名：<input type="text" name="account" /> </li>
    	<li>密　码：<input type="text" name="password" /> </li>
    	<li>昵　称：<input type="text" name="nickname" /> </li>
    	<li><input type="submit" value="确认" /> </li>
    </ul>
    </form>
  </body>
</html>
