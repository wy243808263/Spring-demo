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
    <title>创建user</title>
    <script language="javascript">
    function add(){
	   var userName=document.getElementsByName("username")[0];
	   if(userName.value ==null || userName.value  == ""){
	       alert("userName不能为空……");
	       userName.value ="";
	       userName.focus();
	       return false;
	    }
	   var password=document.getElementsByName("password")[0];
	   if(password.value ==null || password.value  == ""){
	       alert("password不能为空……");
	       password.value ="";
	       password.focus();
	       return false;
	    }
	   var tel=document.getElementsByName("tel")[0];
	   if(tel.value ==null || tel.value  == ""){
	       alert("tel不能为空……");
	       tel.value ="";
	       tel.focus();
	       return false;
	    }
	   var sex=document.getElementsByName("sex")[0];
	   if(sex.value ==null || sex.value  == ""){
	       alert("sex不能为空……");
	       sex.value ="";
	       sex.focus();
	       return false;
	    }
	   var description=document.getElementsByName("description")[0];
	   if(description.value ==null || description.value  == ""){
	       alert("description不能为空……");
	       description.value ="";
	       description.focus();
	       return false;
	    }
	   document.forms[0].submit();
	}
    function goback(){
       location.href="userView.do";
    }
   </script>
  </head>
  <body>
  <form action="userAdd.do" method="post">  
  <table bgcolor="#CCFFFF" border ="0" bordercolor="#969696"  width="500" cellpadding="3" cellspacing="0">
	<tr bgcolor="#99CCFF"><td colspan="100%">userAdd</td></tr>
    <tr><td colspan="100%"><hr size="1" color="#9999FF"></hr></td></tr>
	 <tr><td>userName：
	 <input type="text" name="username"></td></tr>
	 <tr><td>password：
	 <input type="text" name="password"></td></tr>
	 <tr><td>tel：
	 <input type="text" name="tel"></td></tr>
	 <tr><td>sex：
	 <input type="text" name="sex"></td></tr>
	 <tr><td>description：
	 <input type="text" name="description"></td></tr>
	 <tr><td colspan="100%"><hr size="1" color="#9999FF"></hr></td></tr>
	 <tr height="50">
	<td colspan="100%" align="right">
	<input type="button" onclick="add()" value="add" style="background:#CCFFFF"/>&nbsp;&nbsp;&nbsp;
    <input type="button" onclick="goback()" value="goback" style="background:#CCFFFF"/>&nbsp;&nbsp;&nbsp;&nbsp;
	</td></tr>
 </table>
  </form>
  </body>
</html>

