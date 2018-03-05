<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Eventos Disponibles:
	<table>
		<tr bgcolor="#66CC99">
			<th scope="col">Event id</th>
			<th scope="col">Event name</th>
			<th scope="col">Description</th>
			<th scope="col">Places</th>
			<th scope="col">Duration</th>
			<th scope="col">Event type</th>
			<th scope="col">Available Tickets</th>
		</tr>
		<c:forEach var="event" items="${eventos}">

			<tr>
				<td align="center"><c:out value="${event.eventid}"></c:out>
				</td>
				<td align="center"><c:out value="${event.name}"></c:out>
				</td>
				<td align="center"><c:out value="${event.description}"></c:out>
				</td>
				<td align="center"><c:out value="${event.place}"></c:out>
				</td>
				<td align="center"><c:out value="${event.duration}"></c:out>
				</td>
				<td align="center"><c:out value="${event.eventType}"></c:out>
				</td>
				<td align="center"><c:out value="${event.seatsAvailable}"></c:out>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>