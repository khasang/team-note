
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateTable</title>
</head>
<body>
    <p>Our table status: ${create}</p>
    <h1>Insert GET JdbcTemplate</h1>
    <a href="insert">Добавить 4-х котов</a>

    <h1>Реализация через PreparedStatement</h1>
    <a href="cat">Добавить Кота</a>
    <a href="viewcat">Посмотреть всех котов</a>
</body>
</html>
