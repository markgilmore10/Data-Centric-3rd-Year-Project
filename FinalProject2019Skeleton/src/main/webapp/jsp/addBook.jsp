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
<h1>Add New Book</h1>
<form:form method="POST" action="${contextPath}/addBook" modelAttribute="newBook">
    <table>
        <tr>
            <td><form:label path="title">Title:</form:label></td>
            <td><form:input path="title" type="text"/></td>
            <td><form:errors path="title"/></td>
        </tr>
        <tr>
            <td><form:label path="author">Author:</form:label></td>
            <td><form:input path="author" type="text"/></td>
            <td><form:errors path="author" /></td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <tr><td><button type="submit">Add</button></td></tr>
    </table>

</form:form>
<tr>
    <td><a href="/">Home</a></td>
    <td><a href="/addBook">Add Book</a></td>
    <td><a href="/addCustomer">Add Customers</a></td>
    <td><a href="/newLoan">New Loan</a></td>
    <td><a href="/logout">Logout</a></td>
</tr>

</body>
</html>