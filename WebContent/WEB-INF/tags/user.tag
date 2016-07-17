<%@tag pageEncoding="UTF-8"%>
<%@tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="user" required="true"
	type="ua.busstation.core.user.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="ua.busstation.i18n.text" />
<tr>
	<td align="center">${user.login}</td>
	<td align="center">${user.password}</td>
	<td align="center">${user.firstName}</td>
	<td align="center">${user.lastName}</td>
	<td align="center">${user.roleId}</td>
	<td align="center">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="viewEditUser"> <input
				type="hidden" name="id" value="${user.id}"> <input
				type="hidden" name="login" value="${user.login}"> <input
				type="hidden" name="password" value="${user.password}"> <input
				type="hidden" name="firstName" value="${user.firstName}"> <input
				type="hidden" name="lastName" value="${user.lastName}"> <input
				type="hidden" name="roleId" value="${user.roleId}"> 
				<fmt:message key="users.edit" var="edit"/>
				<input type="submit" value="${edit}" class="button green small">
		</form>
	</td>
	<td align="center">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="deleteUser"> <input
				type="hidden" name="id" value="${user.id}"> 
				<fmt:message key="users.delete" var="delete"/>
				<input
				type="submit" value="${delete}" class="button red small">
		</form>
	</td>
</tr>
