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
    <title>leftFrame</title>
  </head>
  <body>
  <TABLE height="100%" cellSpacing="0" cellPadding="0" width="170" background="<%=path %>/login_images/menu_bg.jpg" border=0>
    <TR>
     <TD vAlign=top align="center">
    <TABLE cellSpacing="0" cellPadding="0" width="150" border="0">
       <TR>
        <TD height="10"></TD></TR>
          <TR height="22">
    <TD style="PADDING-LEFT: 15px" background="<%=path %>/login_images/menu_bt.jpg"><A 
          class=menuParent 
          href="<%=basePath %>userView.do" target=main>userManager</A></TD></TR>

          <TR height=22>
   	 <TD style="PADDING-LEFT: 15px">
    	</TD></TR>  	
     </TABLE>
    </TD>
    </TR></TABLE>
  </body>

</html>

