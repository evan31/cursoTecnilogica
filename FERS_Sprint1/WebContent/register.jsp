<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New visitor page registration</title>
<link rel="stylesheet" type="text/css" href="css/register.css">
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
				<td><a href="index.jsp">Log In</a></td>
			</tr>
		</table>
	</div>

	<!-- Messages -->
	<div class="title">Portal Registration Page</div>
	<div class="tip">Fields marked with (*) are mandatory</div>
	<br>

	<!-- Formulario principal -->
	<form action="register.do" method="post" class="main-form-register">
		<table class="tabla-register">
			<tr>
				<td class="info-field">*First Name:</td>
				<td class="input-field"><input type="text" name="firstNameRegister" id="firstNameRegister" required></td>
			</tr>
			<tr>
				<td class="info-field">*Last Name:</td>
				<td class="input-field"><input type="text" name="lastNameRegister" id="LastNameRegister" required></td>
			</tr>
			<tr>
				<td class="info-field">*User Name:</td>
				<td class="input-field"><input type="text" name="userNameRegister" id="userNameRegister" required></td>
			</tr>
			<tr>
				<td class="info-field">*Password:</td>
				<td class="input-field"><input type="password" name="passRegister" id="passRegister" required></td>
			</tr>
			<tr>
				<td class="info-field">*Confirm Password:</td>
				<td class="input-field"><input type="password" name="passConfirmRegister" id="passConfirmRegister" required></td>
			</tr>
			<tr>
				<td class="info-field">*Email:</td>
				<td class="input-field"><input type="text" name="emailRegister" id="emailRegister" required></td>
			</tr>
			<tr>
				<td class="info-field">*DNI (XX.XXX.XXX-L):</td>
				<td class="input-field"><input type="text" name="dniRegister" id="dniRegister" required></td>
			</tr>
			<tr>
				<td class="info-field">*Phone Number:</td>
				<td class="input-field"><input type="text" name="phoneRegister" id="phoneRegister" required></td>
			</tr>
			<tr>
				<td class="info-field">Address:</td>
				<td class="input-field"><input type="text" name="addressRegister" id="addressRegister"></td>
			</tr>
		</table>

		<!-- Error -->
		<div class="error">
			<c:set var="errorRegistro" value="${requestScope.errorRegistro }" />
			<c:if test="${not empty errorRegistro}">
				<c:out value="${errorRegistro }" />
			</c:if>
		</div>

		<input type="submit" value="Register" name="registerBtn">
	</form>
</body>
</html>