<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TableCatDelete</title>
</head>
<body>
<p>Our table Cats upgrade status: ${delete}</p>
<h1>Таблица удаленна переходим к PreparedStatement, но сначало надо пересоздать таблицу</h1>
<h1>Create Table Cat GET JdbcTemplate</h1>
<a href="create">Создать таблицу котов</a>

<h1>Реализация через PreparedStatement</h1>
<a href="catsps/cat">Добавить Кота</a>
<a href="catsps/viewcat">Посмотреть всех котов</a>
</body>
</html>
