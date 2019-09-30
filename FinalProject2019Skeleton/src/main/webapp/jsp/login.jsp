<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ADCWA Final Project</title>
</head>
<body>
<h1>Login with Username And Password</h1>
<form method="POST" action="${contextPath}/login">
    <input name="username" type="text"/>
    <input name="password" type="password"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

<button type="submit">Log In</button>
</form>
</body>
</html>