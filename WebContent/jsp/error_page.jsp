<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
			<a href="controller?command=logout"> Logout </a>
		</c:if>
	</div>

	<div align="center">
		<div class="lc-block">
			<h3>The following error occurred</h3>

			<%-- this way we get the error information (error 404)--%>
			<c:set var="code"
				value="${requestScope['javax.servlet.error.status_code']}" />
			<c:set var="message"
				value="${requestScope['javax.servlet.error.message']}" />

			<c:if test="${not empty code}">
				<h3>
					Error code:
					<c:out value="${code}" />
				</h3>
			</c:if>

			<c:if test="${not empty message}">
				<h3>
					<c:out value="${message}" />
				</h3>
			</c:if>

			<%-- if get this page using forward --%>
			<c:if test="${not empty errorMessage}">
				<p>
					<c:out value="${errorMessage}" />
				</p>
			</c:if>
		</div>
	</div>
</body>
</html>
