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
			<input type="hidden" name="command" value="registration" />
			<div class="lc-block">
				<div>
					<fmt:message key="registration.test" />
					<input type="text" class="style-4" name="login" placeholder="Login"
						required />
				</div>
				<div>
					<input type="password" class="style-4" name="password"
						placeholder="Password" required />
				</div>
				<div>
					<input type="text" class="style-4" name="firstName"
						placeholder="First name" required />
				</div>
				<div>
					<input type="text" class="style-4" name="lastName"
						placeholder="Last name" required />
				</div>
				<div>
					<input type="text" class="style-4" name="email" placeholder="Email"
						required />
				</div>

				<input type="hidden" class="style-4" name="roleId" value="1" />

				<div>
					<input type="submit" value="registration" class="button red small" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>
