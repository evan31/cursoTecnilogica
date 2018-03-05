<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update visitor information</title>
<link rel="stylesheet" type="text/css" href="css/updateVisitorInformation.css">
</head>
<body>
	<!-- Cabecera -->
	<h2 class="cabecera-info">
		Festival Event Registration System
	</h2>

	<!-- Menu -->
	<div>
		<table class="menu1">
			<tr>
				<td><a href="logOut.do">Log Out</a></td>
				<td><a href="#">About</a></td>
				<td><a href="displayView.do?view=portal">My Portal</a></td>
			</tr>
		</table>
	</div>
	<br>

	<!-- Messages -->
	<div class="title">Update your information</div>
	<div class="tip">Fields marked with (*) are mandatory</div>
	<br>

	<!-- Formulario principal -->
	<form action="updateVisitorInformation.do" method="post" class="main-form-update">
		<input type="hidden" value="${sessionScope.usuario.visitorId}" name="visitorId" id="visitorId">
		<table class="tabla-update">
			<tr>
				<td class="info-field">*First Name:</td>
				<td class="input-field"><input type="text" value="${sessionScope.usuario.firstName}" name="firstNameUpdate" id="firstNameUpdate" required></td>
			</tr>
			<tr>
				<td class="info-field">*Last Name:</td>
				<td class="input-field"><input type="text" value="${sessionScope.usuario.lastName}" name="lastNameUpdate" id="lastNameUpdate" required></td>
			</tr>
			<tr>
				<td class="info-field">*User Name:</td>
				<td class="input-field"><input type="text" value="${sessionScope.usuario.userName}" name="userNameUpdate" id="userNameUpdate" required readonly="readonly"></td>
			</tr>
			<tr>
				<td class="info-field">*Email:</td>
				<td class="input-field"><input type="text" value="${sessionScope.usuario.email}" name="emailUpdate" id="emailUpdate" required></td>
			</tr>
			<tr>
				<td class="info-field">*DNI (XX.XXX.XXX-L):</td>
				<td class="input-field"><input type="text" value="${sessionScope.usuario.dni}" name="dniUpdate" id="dniUpdate" required></td>
			</tr>
			<tr>
				<td class="info-field">*Phone Number:</td>
				<td class="input-field"><input type="text" value="${sessionScope.usuario.phoneNumber}" name="phoneUpdate" id="phoneUpdate" required></td>
			</tr>
			<tr>
				<td class="info-field">Address:</td>
				<td class="input-field"><input type="text" value="${sessionScope.usuario.address}" name="addressUpdate" id="addressUpdate"></td>
			</tr>
		</table>
		<!-- Mostrar error -->
		<div class="error">
			<c:set var="errorUpdateVisitor" value="${requestScope.errorUpdateVisitor }" />
			<c:if test="${not empty errorUpdateVisitor}">
				<c:out value="${errorUpdateVisitor }" />
			</c:if>
		</div>
		<input type="submit" value="Update" name="updateBtn">
	</form>
</body>
</html>