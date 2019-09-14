<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dummy Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h1>Add Customer Details</h1>
		
		<form:form modelAttribute="customerBean" action="saveCustomer">
			<form:input path="CustomerName"/>
			<form:input path="customerType"/>
			<form:input path="bill"/>
			<form:input path="date"/>
			
			<form:button>Register</form:button>
		</form:form>
		<a href="{pageContext.request.contextPath}/index.jsp"></a>
	</center>
</body>
</html>