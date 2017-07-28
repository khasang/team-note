<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TableUpdateCats</title>
</head>
<body>
<p>Our table Cats upgrade status: ${update}</p>
<h1>Delete Cat GET JdbcTemplate</h1>
<a href="deleteCat">Удалить 1 кота</a>

<h1>Реализация через PreparedStatement</h1>
<a href="catsps/cat">Добавить Кота</a>
<a href="catsps/viewcat">Посмотреть всех котов</a>
</body>
</html>
