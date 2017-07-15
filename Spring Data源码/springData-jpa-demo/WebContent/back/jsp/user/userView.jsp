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
    <title>user详细界面</title>
    <style type="text/css">
    .td2 { border-bottom: #9999FF solid 1px; }
    .td3 { border-bottom: #9999FF solid 1px;  border-right: #9999FF solid 1px; }
    </style>
    <script language="javascript">	
    function  del(obj){
    			var k = window.confirm("are you sure to delete this item?");
      			if(k){
                     location.href="userDel"+obj+".do";
        			 return true;   
      	 		  }else{
         		 	return false;    
     			  }
     }
      function update(obj){
           location.href="userGoUpdate"+obj+".do";
      }
      function add(){
        location.href="userGoAdd.do";
      }
      </script>
  </head>
  <body>
 <table border="1" rules="none" bordercolor="#969696" style="empty-cells: show"    
 	width="650" cellpadding="2" cellspacing="0">                                     
 	<tr bgcolor="#CCFFFF">                                                           
 		<td colspan="100" class="td2">                                               
 			<font color="0000FF">usershow</font>                                  
 		</td>                          
 	</tr>  
 	<tr align="center" bgcolor="#99CCFF">            
	            <td class="td3">
	              <font color="#0000FF">userId</font>
	            </td>
	            <td class="td3">
	              <font color="#0000FF">userName</font>
	            </td>
	            <td class="td3">
	              <font color="#0000FF">password</font>
	            </td>
	            <td class="td3">
	              <font color="#0000FF">tel</font>
	            </td>
 		<TD class="td2">            
 			<font color="#0000FF">operation</font>           
 		</TD>           
 	</tr>           
 	<c:forEach items="${userList}" var="userList">           
 		<tr align="center">           
				<td width="20%" class="td3">
	              ${userList.userid}
	            </td>
				<td width="20%" class="td3">
	              ${userList.username}
	            </td>
				<td width="20%" class="td3">
	              ${userList.password}
	            </td>
				<td width="20%" class="td3">
	              ${userList.tel}
	            </td>
 			<td class="td2">           
 				<a             
 					onclick="update(${userList.userid});">goupdate</a>           
 				<a           
 					onclick="del(${userList.userid});" >delete</a>           
 			</td>            
 		</tr>            
 	</c:forEach>            
 	<tr height="50" align="right">            
 		<td colspan="100%" bgcolor="#CCFFFF">            
 			<input type="button"           
 				onclick="add()" value="goadd"            
 				style="background: #CCFFFF" />          
 		</td>            
 	</tr>           
 </table>            
  </body>
</html>

