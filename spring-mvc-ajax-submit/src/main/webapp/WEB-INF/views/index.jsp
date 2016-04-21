<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC 测试</title>
		
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="${ctx}/resources/jquery/jquery-1.12.1.min.js"></script>
	</head>
	<body>
		<h1>Hello ${username}</h1>
		
		<input id="username" type="text" name="username">
		<input id="button" type="button" value="提交">
		
		<script type="text/javascript">
			$("#button").click(function(){
				alert("http://localhost:8080/spring-mvc-ajax-submit/ajax/get?username=" + $("#username").val());
				$.get({
					url: '${ctx}/ajax/get',
					data: {'username': $("#username").val()}
				});
			});
		</script>
	</body>
</html>