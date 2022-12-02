<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<form:form action="updateStudent" modelAttribute="student">
		<form:input path="id" readonly="true"/>
		<form:label path="id">Id:</form:label>
		<form:label path="name">Name:</form:label>
		<form:input path="name" />
		<form:label path="email">Email:</form:label>
		<form:input path="email" />
		<form:label path="password">Password:</form:label>
		<form:input path="password" />
		<form:label path="phone">Phone:</form:label>
		<form:input path="phone" />
		<form:label path="school">School:</form:label>
		<form:input path="school" />
		<input type="submit" value="submit">
	</form:form>
</body>
</html>