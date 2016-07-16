<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="ua.busstation.i18n.text" />

<!DOCTYPE html>
<html lang="${language}">
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
		<p>
			<c:if test="${not empty successfulMessage}">
				<fmt:message key="login.successful.message" />
			</c:if>
		</p>
		<form>
			<select id="language" name="language" onchange="submit()">
				<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
				<option value="nl" ${language == 'nl' ? 'selected' : ''}>Nederlands</option>
				<option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
			</select>
		</form>
	</div>
	<div align="center">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="login" />
			<div class="lc-block">
				<div>
				
				<label for="username"><fmt:message key="login.label.username" />:</label>
				
					<input type="text" class="style-4" name="login"
						placeholder="User Name" required />
				</div>
				<div>
				
					<label for="password"><fmt:message key="login.label.password" />:</label>
				
					<input type="password" class="style-4" name="password"
						placeholder="Password" required />
				</div>
				<div>
				
					<fmt:message key="login.button.submit" var="buttonValue" />
				
					<input type="submit" value="${buttonValue}" class="button red small" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>
