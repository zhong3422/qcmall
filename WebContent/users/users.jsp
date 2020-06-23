<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../bootstrap-4.4.1-dist/css/bootstrap.min.css" >
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
<title>用户信息</title>
</head>
<body>
<div class="container">
<table class="table">
	<tr>
		<td>用户id：</td>
		<td>${users.id }</td>
	</tr>
	<tr>
		<td>用户名：</td>
		<td>${users.username }</td>
	</tr>
	<tr>
		<td>密码：</td>
		<td>${users.password }</td>
		<td><button onclick="">编辑</button></td>
	</tr>
	<tr>
		<td>性别：</td>
		<td>${users.sex }</td>
		<td><button onclick="">编辑</button></td>
	</tr>
	<tr>
		<td>默认收货地址：</td>
		<td></td>
		<td><a href="../address"><button onclick="">编辑</button></a></td>
	</tr>
	<tr>
		<td>用户类型：</td>
		<td>${users.type }</td>
	</tr>
	
</table>
</div>
</body>
</html>