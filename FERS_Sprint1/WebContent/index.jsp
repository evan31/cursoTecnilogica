<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>


	<!-- Cabecera -->
	<h2 class="cabecera-info">
		Festival Event LogIn System
	</h2>

	<!-- Formulario principal -->
	<form action="login.do" method="post" class="main-form-login">
		<table class="tabla-login">
			<caption>Portal Login Page</caption>
			<tr>
				<td class="info-field">Visitor name:</td>
				<td class="input-field"><input type="text" name="visitorName" id="visitorName"></td>
			</tr>
			<tr>
				<td class="info-field">Password:</td>
				<td class="input-field"><input type="password" name="passLogin" id="passLogin"></td>
			</tr>
		</table>
		<input type="submit" value="Login" name="loginBtn"><br>
		<!-- Mostrar error -->
		<div class="error">
			<c:set var="errorLogin" value="${requestScope.errorLogin }" />
			<c:if test="${not empty errorLogin}">
				<c:out value="${errorLogin }" />
			</c:if>
		</div>

	</form>

	<!-- Enlace a registro -->
	<div class="register-link">
		New Visitor:<br>
		<a href="register.jsp">register here</a>
	</div>

</body>
</html>