<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Create Cat</title>
</head>
<body>
<h1>Реализация через PreparedStatement</h1>
<h1>Add New Cat</h1>
<form:form method="post" action="save">
    <table >
        <tr>
            <td>Id : </td>
            <td><form:input path="id"  /></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
