<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Выгрузка/Загрузка/Удаление файлов</title>
    <link href="<c:url value='css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Список файлов </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>No.</th>
                    <th>Имя файла</th>
                    <th>Тип</th>
                    <th>Описание</th>
                    <th width="100"></th>
                    <th width="100"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${items}" var="items" varStatus="counter">
                    <tr>
                        <td>${counter.index + 1}</td>
                        <td>${items.name}</td>
                        <td>${items.type}</td>
                        <td>${items.description}</td>
                        <td><a href="<c:url value='/items/download-items-${items.id}' />" class="btn btn-success custom-width">загрузить</a></td>
                        <td><a href="<c:url value='/items/delete-items-${items.id}' />" class="btn btn-danger custom-width">удалить</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="panel panel-default">

        <div class="panel-heading"><span class="lead">Загрузка нового файла</span></div>
        <div class="uploadcontainer">
            <form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="file">Загрузить файл</label>
                        <div class="col-md-7">
                            <form:input type="file" path="file" id="file" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="file" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="file">Описание</label>
                        <div class="col-md-7">
                            <form:input type="text" path="description" id="description" class="form-control input-sm"/>
                        </div>

                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Загрузить" class="btn btn-primary btn-sm">
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>
</body>
</html>