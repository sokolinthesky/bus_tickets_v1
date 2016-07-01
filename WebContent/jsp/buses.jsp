<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>bus-station</title>
    <link href="<c:url value="/css/app.css" />" rel="stylesheet"
          type="text/css">
</head>
<body class="security-app">
<div class="details">
    <h2>Online Bus Station</h2>
</div>
<div align="center">
    <form action="controller" method="post">
    <input type="hidden" name="command" value="reckoning" />
        <div class="lc-block">
            Selected date:<h3> ${date}</h3><br>
            Select bus:<br>
            <c:forEach var="bus" items="${buses}">
                <input type="radio" name="busNumber" value="${bus.trainNumber}"><strong>${bus.trainNumber}
                [seats: ${bus.seats}/40]</strong><br>
            </c:forEach>
            <input type="submit" value="Submit" class="button green small">
        </div>
    </form>
</div>

</body>
</html>