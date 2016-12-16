<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Game</title>
</head>
<body>
    <h1>Find Game</h1>
    <br><br>
    <form name="findGameForm" method="POST" action="/games/viewGamesSearch">
        Find Game
        <input type="text" name="searchStr">
        <input type="submit">
    </form>

    <%--ADD SCRIPT HERE--%>

    <br><br>
    <a href="/">HOME</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/games/viewAllGames">All Games</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/games/addGame">Add New Game</a>
</body>
</html>