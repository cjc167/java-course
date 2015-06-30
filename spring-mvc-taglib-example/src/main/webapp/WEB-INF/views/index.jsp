<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spring MVC 测试</title>
	</head>
	<body>
		<h1>Hello ${user.username}</h1><br/>
		<h1>密码为: ${user.password}</h1><br/>
		<h1>性别为: ${user.sex}</h1><br/>
		<h1>是否已婚: ${user.married}</h1><br/>
		<h1>年龄为: ${user.age}</h1><br/>
		<h1>学历为: ${user.degree}</h1><br/>
		<h1>兴趣爱好是: ${user.interest}</h1><br/>
		
		<form:form action="${pageContext.request.contextPath}/index.html" method="POST" commandName="user">
			<table>
				<tr>
					<td>用户名:</td>
					<td><form:input path="username"/></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><form:password path="password"/></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td>
						<form:radiobuttons path="sex" items="${user.sexList}"/>
					</td>
				</tr>
				<tr>
					<td>是否已婚:</td>
					<td>
						<form:radiobuttons path="married" items="${user.marriedList}" itemLabel="key" itemValue="value"/>
					</td>
				</tr>
				<tr>
					<td>年龄:</td>
					<td>
						<form:select path="age" items="${user.ageList}"/>
					</td>
				</tr>
				<tr>
					<td>学历:</td>
					<td>
						<form:select path="degree" items="${user.degreeList}" itemLabel="key" itemValue="value"/>
					</td>
				</tr>
				<tr>
					<td>兴趣爱好:</td>
					<td>
						<form:checkboxes path="interest" items="${user.interestList}" itemLabel="key" itemValue="value"/>
					</td>
				</tr>
			</table>
			<input type="hidden" name="">
			<input type="submit" value="提交">
		</form:form>
	</body>
</html>