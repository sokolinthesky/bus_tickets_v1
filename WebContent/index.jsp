<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<sql:query var="listBuses" dataSource="jdbc/busstation">
    select id, train_number from buses;
</sql:query>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buses List</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of buses</h2></caption>
            <tr>
                <th>id</th>
                <th>busNumber</th>
            </tr>
            <c:forEach var="bus" items="${listBuses.rows}">
                <tr>
                    <td><c:out value="${bus.id}" /></td>
                    <td><c:out value="${bus.train_number}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>