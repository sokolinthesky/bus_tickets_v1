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
    <div class="lc-block">
        <h1>Ticket:</h1>
        <strong>Bus number:</strong> ${reckoning.bus.trainNumber}<br>
        <strong>Route:</strong> ${reckoning.route.name}<br>
        <strong>Date:</strong> ${reckoning.bus.date}<br>
        <strong>Departure time:</strong> ${reckoning.route.departureTime}<br>
        <strong>Destination time:</strong> ${reckoning.route.destinationTime}<br>
        <strong>Seat:</strong> ${reckoning.bus.seats + 1}<br>
        <strong>Price:</strong> ${reckoning.route.price}
    </div>
   </div>
</body>
</html>