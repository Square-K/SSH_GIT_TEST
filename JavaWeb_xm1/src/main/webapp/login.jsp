<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登录</title>
	</head>
	<body>
		<form action="/JavaWeb_xm1/UserServlet?pd=userLogin" method="post">
			<h4>登录账号</h4>
			账号：<input type="text" name="userName" /><br />
			密码：<input type="password" name="userPass" /><br />
			<input type="submit" value="提交" />
		</form>
		<% String massages = (String)request.getAttribute("massages"); %>
		<% if(massages != null){ %>
			<h4 style="color: red;"><%= massages %></h4>
		<% } %>
	</body>
</html>