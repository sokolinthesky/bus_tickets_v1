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
		</c:if>
		<a href="controller?command=logout"> Logout </a>
	</div>

	<div align="center">

		<form action="controller" method="post">
			<input type="hidden" name="command" value="editUser" />
			<div class="lc-block">
				<input type="hidden" name="id" value="${user.id}">
				<div>
					<input type="text" class="style-4" name="login"
						placeholder="User Name" value="${user.login}"/>
				</div>
				<div>
					<input type="text" class="style-4" name="password"
						placeholder="Password" value="${user.password}"/>
				</div>
				<div>
					<input type="text" class="style-4" name="firstName"
						placeholder="First name" value="${user.firstName}"/>
				</div>
				<div>
					<input type="text" class="style-4" name="lastName"
						placeholder="Last name" value="${user.lastName}"/>
				</div>
				<div>
					<input type="text" class="style-4" name="roleId"
						placeholder="Role id" value="${user.roleId}"/>
				</div>
				<div>
					<input type="submit" value="submit" class="button red small" />
				</div>
			</div>
		</form>
	</div>
</body>
</html>
