<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>ViewCat</title>
</head>
<body>
<h1>Реализация через PreparedStatement</h1>
<h1>Cats List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="cat" items="${list}">
        <tr>
            <td>${cat.id}</td>
            <td>${cat.name}</td>
            <td><a href="editcat/${cat.id}">Edit</a></td>
            <td><a href="deletecat/${cat.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="cat">Add New Cat</a>
</body>
</html>
