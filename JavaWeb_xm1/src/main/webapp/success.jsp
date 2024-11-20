<%@page import="com.seiryo.entity.MyUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>主界面</title>
	</head>
	<body>
		<!-- 拿到 req 中的数据 -->
		<% List<MyUser> userList = (List<MyUser>)request.getAttribute("userList"); %>
		<% for(MyUser user:userList){ %>
			<div>
				<p>编号：<%= user.getUserId() %></p>
				<p>账号：<%= user.getUserName() %></p>
				<p>密码：<%= user.getUserPass() %></p>
				<p><a href="/JavaWeb_xm1/UserServlet?userId=<%= user.getUserId() %>&userName=<%= user.getUserName() %>&userPass=<%= user.getUserPass() %>&pd=userViewTzUpdate">修改信息</a></p>
				<p><a href="">删除数据</a></p>
			</div>
		<% } %>
	</body>
</html>