<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="css/app.css" />" rel="stylesheet"
	type="text/css">
<title>busstation</title>
</head>
<body class="security-app">
	<div class="details">
		<h2>Online Bus Station</h2>
	</div>
	<div align="center">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="login" />
			<div class="lc-block">
				<div>
					<input type="text" class="style-4" name="login"
						placeholder="User Name" />
				</div>
				<div>
					<input type="password" class="style-4" name="password"
						placeholder="Password" />
				</div>
				<div>
					<input type="submit" value="submit" class="button red small" />
				</div>
				<c:if test="${param.error ne null}">
					<div class="alert-danger">Invalid username and password.</div>
				</c:if>
				<c:if test="${param.logout ne null}">
					<div class="alert-normal">You have been logged out.</div>
				</c:if>
			</div>
		</form>
	</div>
</body>
</html>
