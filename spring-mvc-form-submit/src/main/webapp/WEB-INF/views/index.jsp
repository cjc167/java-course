<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC 测试</title>
	</head>
	<body>
		<h1>Hello ${username}</h1>
		
		<form action="index.html">
			<input type="text" name="username">
			<input type="submit" value="提交">
		</form>
	</body>
</html>