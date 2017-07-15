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
    <title>shirodemo login page</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.6.3.min.js"/>'></script>
	<script type="text/javascript">
	<!--
	function reloadValidateCode(){
		$("#validateCodeImg").attr("src","<%=basePath%>/validateCode?data=" + new Date() + Math.floor(Math.random()*24));
	}
	//-->
	</script>
  </head>
  
  <body>
    <form action="<%=basePath%>/login" method="post">
    <ul>
    	<li>姓　名：<input type="text" name="account" /> </li>
    	<li>密　码：<input type="text" name="password" /> </li>
    	<li>验证码：<input type="text" name="validateCode" />&nbsp;&nbsp;<img id="validateCodeImg" src="<%=basePath%>/validateCode" />&nbsp;&nbsp;<a href="#" onclick="javascript:reloadValidateCode();">看不清？</a></li>
    	<li><input type="submit" value="确认" /> </li>
    </ul>
    </form>
  </body>
</html>
