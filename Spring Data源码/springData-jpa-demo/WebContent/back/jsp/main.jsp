<%@ page language="java"  import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>mainFrame</title>
  </head>
  <frameset border="0" framespacing="0" rows="60, *" frameborder="0">
  <FRAME name=header src="<%=basePath %>back/jsp/header.jsp" frameBorder="0" noResize scrolling=no>
  <FRAMESET cols="210, *">
  <FRAME name=menu src="<%=basePath %>back/jsp/left.jsp" frameBorder="0" noResize>
  <FRAME name=main src="<%=basePath %>back/jsp/right.jsp" frameBorder="0" noResize scrolling=yes>
  </FRAMESET>
  </frameset>
  <noframes>
  </noframes>

</html>

