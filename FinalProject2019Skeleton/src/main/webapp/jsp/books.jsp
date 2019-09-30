<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ADCWA Final Project</title>
</head>
<body>
<h1>List of Books</h1>
<table>
    <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>Author</th>
    </tr>
    <c:forEach items="${bookList}" var="book" varStatus="status">
        <tr>
            <td>${book.bid}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
        </tr>
    </c:forEach>
</table>
<tr>
    <td><a href="/">Home</a></td>
    <td><a href="/addBook">Add Book</a></td>
    <td><a href="/showCustomers">List Customers</a></td>
    <td><a href="/showLoans">List Loans</a></td>
    <td><a href="/logout">Logout</a></td>
</tr>

</body>
</html>