<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update visitor password</title>
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
	<br>

	<!-- Formulario principal -->
	<form action="updateVisitorPassword.do" method="post" class="main-form-update">
		<table class="tabla-update">
			<tr>
				<td class="info-field">Current password:</td>
				<td class="input-field"><input type="password" name="currentPass" id="currentPass"></td>
			</tr>
			<tr>
				<td class="info-field">New Password:</td>
				<td class="input-field"><input type="password" name="newPass" id="newPass"></td>
			</tr>
			<tr>
				<td class="info-field">Repeat new password:</td>
				<td class="input-field"><input type="password" name="newPassRepeat" id="newPassRepeat"></td>
			</tr>
		</table>
		<!-- Mostrar error -->
		<div class="error">
			<c:set var="errorUpdatePass" value="${requestScope.errorUpdatePass }" />
			<c:if test="${not empty errorUpdatePass}">
				<c:out value="${errorUpdatePass }" />
			</c:if>
		</div>
		<input type="submit" value="Update" name="updateBtn">
	</form>
</body>
</html>