<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
			<fmt:message key="login.button.registration" var="buttonReg" />
			<input type="hidden" name="command" value="viewRegistration" /> <input
				type="submit" value="${buttonReg}" class="button green small">
		</form>
		<p>
			<c:if test="${not empty successfulMessage}">
				<fmt:message key="login.successful.message" />
			</c:if>
		</p>
		<form method="post">
			<select id="language" name="language" onchange="submit()">
				<option value="nl" ${language == 'uk' ? 'selected' : ''}>Ukrainian</option>
				<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
			</select>
		</form>
	</div>
	<div align="center">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="login" />
			<div class="lc-block">
				<div>
					<fmt:message key="login.label.username" var="login" />
					<input type="text" class="style-4" name="login"
						placeholder="${login}" required />
				</div>
				<div>
					<fmt:message key="login.label.password" var="password" />
					<input type="password" class="style-4" name="password"
						placeholder="${password}" required />
				</div>
				<div>

					<fmt:message key="login.button.submit" var="buttonValue" />

					<input type="submit" value="${buttonValue}"
						class="button red small" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>
