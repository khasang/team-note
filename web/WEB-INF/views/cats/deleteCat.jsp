<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Cat</title>
</head>
<body>
<p>Our table Cats upgrade status: ${deleteCat}</p>
<h1>Delete Table Cat GET JdbcTemplate</h1>
<a href="delete">Удалить таблицу котов</a>

<h1>Реализация через PreparedStatement</h1>
<a href="catsps/cat">Добавить Кота</a>
<a href="catsps/viewcat">Посмотреть всех котов</a>
</body>
</html>
