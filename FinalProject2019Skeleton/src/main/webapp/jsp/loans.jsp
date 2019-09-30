<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ADCWA Final Project</title>
</head>
<body>
<h1>List of Loans</h1>
<table>
    <tr>
        <th>Loan ID</th>
        <th>Customer ID</th>
        <th>Customer Name</th>
        <th>Book Title</th>
        <th>Author</th>
        <th>Due date</th>
    </tr>
    <c:forEach items="${listLoans}" var="loan">
        <tr>
            <td>${loan.lid}</td>
            <td>${loan.cust.cId}</td>
            <td>${loan.cust.cName}</td>
            <td>${loan.book.title}</td>
            <td>${loan.book.author}</td>
            <td>${loan.dueDate}</td>
        </tr>
    </c:forEach>
</table>
<tr>
    <td><a href="/">Home</a></td>
    <td><a href="/showBooks">List Books</a></td>
    <td><a href="/showCustomers">List Customers</a></td>
    <td><a href="/showLoans">List Loans</a></td>
    <td><a href="/deleteLoan">Delete Loan</a></td>
    <td><a href="/logout">Logout</a></td>
</tr>

</body>
</html>