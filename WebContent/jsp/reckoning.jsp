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
		<a href="controller?command=logout"><fmt:message
				key="common.logout" /></a>
	</div>
	<div align="center">
		<div class="lc-block">
			<h1>
				<fmt:message key="reckonong.ticket" />
				:
			</h1>
			<strong><fmt:message key="reckonong.busnumber" />:</strong>
			${reckoning.bus.trainNumber}<br> <strong><fmt:message
					key="reckonong.route" />:</strong> ${reckoning.route.name}<br> <strong><fmt:message
					key="reckonong.date" />:</strong> ${reckoning.bus.date}<br> <strong><fmt:message
					key="reckonong.departuretime" />:</strong> ${reckoning.route.departureTime}<br>
			<strong><fmt:message key="reckonong.destinationtime" />:</strong>
			${reckoning.route.destinationTime}<br> <strong><fmt:message
					key="reckonong.seat" />:</strong> ${reckoning.bus.seats + 1}<br> <strong><fmt:message
					key="reckonong.price" />:</strong> ${reckoning.route.price}
		</div>
	</div>
</body>
</html>