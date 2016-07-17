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
		<c:out value="${user.firstName} ${user.lastName}" />
		<c:if test="${not empty userRole}">
			<c:out value="(${userRole.name})" />
		</c:if>
		<a href="controller?command=logout"> <fmt:message
				key="common.logout" />
		</a>
	</div>

	<div align="center">

		<form action="controller" method="post">
			<input type="hidden" name="command" value="editUser" />
			<div class="lc-block">
				<input type="hidden" name="id" value="${user.id}">
				<div>
					<fmt:message key="registration.placeholder.login" var="loginM" />
					<input type="text" class="style-4" name="login"
						placeholder="${loginM}" value="${user.login}" />
				</div>
				<div>
					<fmt:message key="registration.placeholder.password" var="password" />
					<input type="text" class="style-4" name="password"
						placeholder="${password}" value="${user.password}" />
				</div>
				<div>
					<fmt:message key="registration.placeholder.firstname"
						var="firstName" />
					<input type="text" class="style-4" name="firstName"
						placeholder="${firstName}" value="${user.firstName}" />
				</div>
				<div>
					<fmt:message key="registration.placeholder.secondname"
						var="secondname" />
					<input type="text" class="style-4" name="lastName"
						placeholder="${secondname}" value="${user.lastName}" />
				</div>
				<div>
					<fmt:message key="users.roleid" var="roleId" />
					<input type="text" class="style-4" name="roleId"
						placeholder="${roleId}" value="${user.roleId}" />
				</div>
				<div>
				<fmt:message key="edituser.button.submit" var="submit"/>
					<input type="submit" value="${submit}" class="button red small" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>
