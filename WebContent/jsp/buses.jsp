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
		<a href="controller?command=logout"> <fmt:message
				key="common.logout" />
		</a>
	</div>
	<div align="center">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="reckoning" />
			<div class="lc-block">
				<fmt:message key="buses.selecteddate" />:
				<h3>${date}</h3>
				<br>
				<fmt:message key="buses.selectbus" />:<br>
				<c:forEach var="bus" items="${buses}">
					<input type="radio" name="busNumber" value="${bus.trainNumber}"
						required>
					<strong>${bus.trainNumber} [<fmt:message key="buses.seats" />: ${bus.seats}/40]</strong>
					<br>
				</c:forEach>
				<fmt:message key="common.button.submit" var="submit"/>
				<input type="submit" value="${submit}" class="button green small">
			</div>
		</form>
	</div>

</body>
</html>