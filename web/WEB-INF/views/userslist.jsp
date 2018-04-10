<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Пользователи</title>
    <link href="<c:url value='css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Список Пользователей</span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ИМя:</th>
                    <th>Фамилия:</th>
                    <th>E-mail:</th>
                    <th>Аккаунт:</th>
                    <th>Пароль:</th>
                    <th width="100"></th>
                    <th width="100"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td>${user.accountName}</td>
                        <td>${user.password}</td>
                        <td><a href="<c:url value='/edit-user-${user.accountName}' />" class="btn btn-success custom-width">edit</a></td>
                        <td><a href="<c:url value='/delete-user-${user.accountName}' />" class="btn btn-danger custom-width">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="well">
        <a href="<c:url value='/items/newuser' />">Добавить нового пользователя</a>
    </div>
</div>
</body>
</html>
