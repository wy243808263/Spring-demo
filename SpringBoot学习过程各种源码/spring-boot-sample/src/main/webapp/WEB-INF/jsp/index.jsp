<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Spring Boot Sample</title>
<script type="text/javascript" src="${pageContext.request.contextPath }${urls.getForLookupPath('/js/common.js') }"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/webjarslocator/jquery/jquery.js"></script>
</head>

<body>
	Time: ${time}
	<br/>
	Message: ${message}
	<br/>
	<img alt="读取默认配置中的图片" src="${pageContext.request.contextPath }/pic.jpg">
	<br/>
	<img alt="读取自定义配置myres中的图片" src="${pageContext.request.contextPath }/myres/fengjing.jpg"  />
</body>
</html>
