<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
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
<link href="<c:url value="/css/app.css" />" rel="stylesheet"
	type="text/css">
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
			<input type="hidden" name="command" value="users" />
			<div class="lc-block">
				<table border="1">
					<tr>
						<th><fmt:message key="users.login" /></th>
						<th><fmt:message key="users.password" /></th>
						<th><fmt:message key="users.firstname" /></th>
						<th><fmt:message key="users.secondname" /></th>
						<th><fmt:message key="users.roleid" /></th>
						<th colspan="2"><fmt:message key="users.actions" /></th>
					</tr>

					<c:forEach var="user" items="${users}">
						<tags:user user="${user}" />
					</c:forEach>
				</table>
			</div>
		</form>
	</div>

</body>
</html>