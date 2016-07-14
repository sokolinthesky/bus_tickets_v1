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

		<form action="controller" method="post">
			<input type="hidden" name="command" value="registration" />
			<div class="lc-block">
				<div>
					<input type="text" class="style-4" name="login"
						placeholder="Login" required/>
				</div>
				<div>
					<input type="password" class="style-4" name="password"
						placeholder="Password" required/>
				</div>
				<div>
					<input type="text" class="style-4" name="firstName"
						placeholder="First name" required/>
				</div>
				<div>
					<input type="text" class="style-4" name="lastName"
						placeholder="Last name" required/>
				</div>
				<div>
					<input type="text" class="style-4" name="email"
						placeholder="Email" required/>
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
