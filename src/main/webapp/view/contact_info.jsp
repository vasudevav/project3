<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color: blue; text-align: center">ContactBook</h1>
<b style="color: green">${errMsg}</b>
<b style="color: red">${successMsg}</b>

<form:form action="saveContact" method="POST" modelAttribute="contact">
	<form:hidden path="contactId" />

	<table border="1">
		<tr>
			<th>Enter Name::</th>
			<td><form:input path="contactName" /></td>
		</tr>
		<tr>
			<th>Enter Email::</th>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<th>Enter Number::</th>
			<td><form:input path="phNo" /></td>
		</tr>
		<tr>
			<td><input type="reset" value="reset" />&nbsp;&nbsp;</td>
			<td><input type="submit" value="submit" /></td>
		</tr>
	</table>

	<br>
	<br>
	<a href="/getAllContact">ShowAllContact</a>
</form:form>

