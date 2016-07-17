<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="ua.busstation.i18n.text" />
<html lang="${language}">
<head>
<title>bus-station</title>
<link rel="stylesheet" type="text/css" href="css/app.css">

</head>
<body class="security-app">

	<div class="details">
		<h2>Online Bus Station</h2>
		<form method="post">
			<select id="language" name="language" onchange="submit()">
				<option value="nl" ${language == 'uk' ? 'selected' : ''}>Ukrainian</option>
				<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
			</select>
		</form>
	</div>

	<div align="center">

		<form action="controller" method="post">
			<input type="hidden" name="command" value="registration" />
			<div class="lc-block">
				<div>
					<fmt:message key="registration.placeholder.login" var="loginM" />
					<input type="text" class="style-4" name="login" placeholder="${loginM}"
						required />
				</div>
				<div>
					<fmt:message key="registration.placeholder.password" var="password" />
					<input type="password" class="style-4" name="password"
						placeholder="${password}" required />
				</div>
				<div>
					<fmt:message key="registration.placeholder.firstname" var="firstName" />
					<input type="text" class="style-4" name="firstName"
						placeholder="${firstName}" required />
				</div>
				<div>
					<fmt:message key="registration.placeholder.secondname" var="secondname" />
					<input type="text" class="style-4" name="lastName"
						placeholder="${secondname}" required />
				</div>
				<div>
					<fmt:message key="registration.placeholder.email" var="email" />
					<input type="text" class="style-4" name="email" placeholder="${email}"
						required />
				</div>

				<input type="hidden" class="style-4" name="roleId" value="1" />

				<div>
					<fmt:message key="registration.button.submit" var="submit" />
					<input type="submit" value="${submit}" class="button red small" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>
