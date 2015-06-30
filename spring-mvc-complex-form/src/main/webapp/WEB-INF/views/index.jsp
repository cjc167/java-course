<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<h1>学历为: ${user.degree}</h1><br/>
		<h1>兴趣爱好是: ${user.interest}</h1><br/>
		
		<form action="index.html">
			<table>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td>
						<input type="radio" name="sex" value="female">女性
						<input type="radio" name="sex" value="male">男性
					</td>
				</tr>
				<tr>
					<td>学历:</td>
					<td>
						<select name="degree">
							<option value="junior">大专</option>
							<option value="regular">本科</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>兴趣爱好:</td>
					<td>
						<input type="checkbox" name="interest" value="movie">电影
						<input type="checkbox" name="interest" value="games">游戏
					</td>
				</tr>
			</table>
			<input type="hidden" name="">
			<input type="submit" value="提交">
		</form>
	</body>
</html>