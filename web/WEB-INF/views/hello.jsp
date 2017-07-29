<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Pages</title>
</head>
<body>
<h1>${name}</h1>

<a href="create">Создать таблицу кошачий магазин</a>

<h1>Реализация через PreparedStatement</h1>

<a href="cat">Добавить Кота</a>
<a href="viewcat">Посмотреть всех котов</a>

<h1>Реализация pgdump.exe - сделать бекап таблицы: </h1>

<a href="backup">Создать бекап базы</a>
</body>
</html>
