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
<h1>Delete Loan</h1>
<c:if test="${not empty error}">
    <p>${error}</p>
</c:if>

<form:form method="POST" action="${contextPath}/deleteLoan" modelAttribute="deleteLoan">
    <table>
        <tr>
            <td><form:label path="lid">Loan ID:</form:label></td>
            <td><form:input path="lid" type="text"/></td>
            <td><form:errors path="lid"/></td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <tr><td><button type="submit">Delete</button></td></tr>
    </table>

</form:form>
<tr>
	<td><a href="/">Home</a></td>
	<td><a href="/showBooks">List Books</a></td>
	<td><a href="/showCustomers">List Customers</a></td>
	<td><a href="/showLoans">List Loans</a></td>
	<td><a href="/newLoan">New Loan</a></td>
	<td><a href="/logout">Logout</a></td>
</tr>
</body>
</html>