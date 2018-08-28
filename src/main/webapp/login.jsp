<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Teste</title>
</head>
<body>
    
    <form:form action="/enter" method="POST" modelAttribute="user">
    	<form:input path="email" />
    	<form:password path="password" />
    	<button type="submit">Entrar</button>
    </form:form>
    
</body>
</html>