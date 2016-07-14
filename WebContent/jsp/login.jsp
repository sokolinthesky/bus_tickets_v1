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
		<form action="controller">
			<input type="hidden" name="command" value="viewRegistration" /> <input
				type="submit" value="registration" class="button green small">
		</form>
		<c:if test="${not empty successfulMessage}">
			<c:out value="${successfulMessage}"></c:out>
		</c:if>
	</div>
	<div align="center">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="login" />
			<div class="lc-block">
				<div>
					<input type="text" class="style-4" name="login"
						placeholder="User Name" required />
				</div>
				<div>
					<input type="password" class="style-4" name="password"
						placeholder="Password" required />
				</div>
				<div>
					<input type="submit" value="submit" class="button red small" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>
