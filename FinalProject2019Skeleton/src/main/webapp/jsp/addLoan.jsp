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
<c:if test="${not empty error}">
    <h1>Could not create new Loan</h1>
    <h2>${error}</h2>
</c:if>

<c:if test="${empty error}">
    <h1>Add New Loan</h1>
<form:form method="POST" action="${contextPath}/newLoan" modelAttribute="newLoan">
    <table>
        <tr>
            <td><form:label path="cust.cId">Customer ID:</form:label></td>
            <td><form:input path="cust.cId" type="text"/></td>
            <td><form:errors path="cust.cId"/></td>
        </tr>
        <tr>
            <td><form:label path="book.bid">Book ID:</form:label></td>
            <td><form:input path="book.bid" type="text"/></td>
            <td><form:errors path="cust.cId"/></td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <tr><td><button type="submit">Loan Book!</button></td></tr>
    </table>

</form:form>
</c:if>
<tr>
	<td><a href="/">Home</a></td>
	<td><a href="/showBooks">List Books</a></td>
	<td><a href="/showCustomers">List Customers</a></td>
	<td><a href="/showLoans">List Loans</a></td>
	<td><a href="/logout">Logout</a></td>
</tr>
</body>
</html>