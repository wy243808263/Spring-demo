<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
	<%
		String path = request.getContextPath();
	%>
	<HEAD>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<link href="<%=path%>/css/global.css" rel="stylesheet" type="text/css" />
		<title>Insert title here</title>
<script language="javascript">
function suReturn(){
		var a=document.getElementsByName("turl")[0].value;
		window.location=a;		
	}

</script>

</head>
<body>
<center>
<input type="hidden" name="turl" value="<%=path%>/${url}"></input>
<br><br>

<table width="650" border="0">
				<tr><td height="35" valign="bottom"><b>=>信息提示</b></td></tr>
				<tr><td height="30" valign="top"><hr/></td></tr>
			</table>
<table  bgcolor="" width="400"  border="0" cellspacing="0" cellpadding="0">  
  <tr><td><br/></td></tr><tr><td><br/></td></tr><tr><td><br/></td></tr><tr><td><br/></td></tr>
  <tr><td>${message1}<br/></td></tr>
   <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;${message2}<br/></td></tr>
    <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${message3}<br/></td></tr>
  
  <tr><td colspan="3" align="right" height="40"  style="padding-right:65px; padding-bottom:12px;"><input type="button" class="btn-20" onClick="suReturn()" value='返回'/></td></tr>
</table>
</center>
</body>
</html>
</center>
</body>
</html>