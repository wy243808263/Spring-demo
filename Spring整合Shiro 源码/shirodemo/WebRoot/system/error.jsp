<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Exception!</title>
  </head>
  
  <body>
	<% Exception ex = (Exception)request.getAttribute("exception"); %>
	<H2>Exception: <%= ex.getMessage()%></H2>
	<P/>
	<% ex.printStackTrace(new java.io.PrintWriter(out));%>
  </body>
</html>