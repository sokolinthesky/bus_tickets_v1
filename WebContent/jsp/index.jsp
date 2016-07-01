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
	</div>

	<div align="center">
		<h1>Welcome!</h1>

		<form action="controller" method="post">
			<input type="hidden" name="command" value="buses" />
			<div class="lc-block">
				<div>
					Select date:<br> <input type="date" name="date">
				</div>
				<br>
				<div>
					Select route:<br> <select name="routeName">
						<c:forEach var="route" items="${routes}">
							<option value="${route.name}">${route.name}
								[${route.departureTime} - ${route.destinationTime}]</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<input type="submit" value="Submit" class="button green small">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
