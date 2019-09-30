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
<h1>List of Customers</h1>
<c:forEach items="${customerList}" var="customer" varStatus="status">
    <h2>${customer.cId} ${customer.cName}</h2>
    <p>Loan Period = ${customer.loanPeriod} days</p>
    <h5>${customer.cName}'s Loans</h5>
    <table>
        <tr>
            <th>Loan ID</th>
            <th>Book ID</th>
            <th>Title</th>
            <th>Author</th>
        </tr>
        <c:forEach items="${loanList}" var="loan" varStatus="status">
            <c:if test="${loan.cust.cId == customer.cId}">
                <tr>
                    <td>${loan.lid}</td>
                    <td>${loan.book.bid}</td>
                    <td>${loan.book.title}</td>
                    <td>${loan.book.author}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</c:forEach>
<tr>
	<td><a href="/">Home</a></td>
	<td><a href="/showBooks">List Books</a></td>
	<td><a href="/showCustomers">List Customers</a></td>
	<td><a href="/showLoans">List Loans</a></td>
	<td><a href="/logout">Logout</a></td>
</tr>
</body>
</html>