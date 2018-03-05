<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Portal</title>
<link rel="stylesheet" type="text/css" href="css/portal.css">
</head>
<body>
	<!-- Cabecera -->
	<h2 class="cabecera-info">
		Festival Registration System
	</h2>

	<!-- Menu -->
	<div>
		<table class="menu1">
			<tr>
				<td><a href="logOut.do">Log Out</a></td>
				<td><a href="#">About</a></td>
				<td><a href="#">Event Catalogue</a></td>
			</tr>
		</table>
	</div>
	<br>

	<!-- Messages -->
	<div class="title">Festival Portal Page:welcome to your portal page:</div>
	<br>

	<!-- Information -->
	<div class="personal-info">
		<div>
			Your personal information is below.
			 	To change your information <a href="displayView.do?view=updateInfo">click here</a>.
			 	To change your password <a href="displayView.do?view=updatePass">click here</a><br>
			UserName: <c:out value="${sessionScope.usuario.userName}" /><br>
			VisitorID: <c:out value="${sessionScope.usuario.visitorId}" /><br>
			Email: <c:out value="${sessionScope.usuario.email}" /><br>
			Phone Number: <c:out value="${sessionScope.usuario.phoneNumber}" /><br>
			Address: <c:out value="${sessionScope.usuario.address}" /><br>
		</div>
	</div>

	<div class="linea"></div>

	<!-- Primera tabla -->
		<!-- Estructura -->
	<div class="title">To release a ticket you have for an upcoming attraction,
	 please find de attraction below,
	 and click the release ticket</div>
	<br>
	<table class="tabla1">
		<tr>
			<th>Event Id</th>
			<th>Event name</th>
			<th>Description</th>
			<th>Places</th>
			<th>Duration</th>
			<th>Event type</th>
			<th>Action</th>
		</tr>
		<!-- Datos -->
		<c:forEach var="evento" items="${sessionScope.usuario.registeredEvents }">
			<tr>
				<td><c:out value="${evento.eventId}" /></td>
				<td><c:out value="${evento.name}" /></td>
				<td><c:out value="${evento.description}" /></td>
				<td><c:out value="${evento.place}" /></td>
				<td><c:out value="${evento.duration}" /></td>
				<td><c:out value="${evento.eventType}" /></td>
				<td><a href="eventUnReg.do?id=${evento.eventId}">Refund</a></td>
			</tr>
		</c:forEach>
	</table>

	<div class="linea"></div>

	<!-- Segunda tabla -->
		<!-- Estructura -->
	<div class="title">To get a ticket for an up-coming attraction,
	 please find the attraction below,
	 and click the Register link</div>
	<br>
	<table class="tabla2">
		<tr>
			<th>Event Id</th>
			<th>Event name</th>
			<th>Description</th>
			<th>Places</th>
			<th>Duration</th>
			<th>Seats Availables</th>
			<th>Event type</th>
			<th>Action</th>
		</tr>
		<!-- Datos -->
		<c:forEach var="evento" items="${applicationScope.eventos }">
			<tr>
				<td><c:out value="${evento.eventId}" /></td>
				<td><c:out value="${evento.name}" /></td>
				<td><c:out value="${evento.description}" /></td>
				<td><c:out value="${evento.place}" /></td>
				<td><c:out value="${evento.duration}" /></td>
				<td><c:out value="${evento.seatsAvailable}" /></td>
				<td><c:out value="${evento.eventType}" /></td>
				<td><a href="eventReg.do?id=${evento.eventId}">Buy</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="error">
		<c:out value="${requestScope.errorAddEvent}" />
	</div>
</body>
</html>