<%@page import="com.seiryo.entity.MyUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改界面</title>
	</head>
	<body>
		<% MyUser user = (MyUser)request.getAttribute("user"); %>
		<form action="/JavaWeb_xm1/UserServlet?pd=userUpdate" method="post">
			编号：<input type="text" value="<%= user.getUserId() %>" readonly="readonly" name="userId" /><br />
			账号：<input type="text" value="<%= user.getUserName() %>" readonly="readonly" name="userName" /><br />
			密码：<input type="text" value="<%= user.getUserPass() %>" name="userPass" /><br />
			<input type="submit" value="提交修改" />
		</form>
	</body>
</html>