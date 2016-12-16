<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Game</title>
</head>
<body>
<h1>View Game</h1>
<br><br>
<table>
    <tr>
        <td>Game Id:</td>
        <td><c:out value="${game.gameId}" /></td>
    </tr>
    <tr>
        <td>Game Title:</td>
        <td><c:out value="${game.gameTitle}" /></td>
    </tr>
    <tr>
        <td>Game Description:</td>
        <td><c:out value="${game.gameDescription}" /></td>
    </tr>
    <tr>
        <td>Game Description:</td>
        <td><c:out value="${game.gameDescription}" /></td>
    </tr>

    <%--ADD SCRIPT HERE--%>
    <tr>
        <td>Category:</td>
        <td><c:out value="${category.categoryTitle}" /></td>
    </tr>

    <tr>
        <td>Category Id:</td>
        <td><c:out value="${game.categoryId}" /></td>
    </tr>
    <tr>
        <td>Vendor:</td>
        <td><c:out value="${vendor.vendorName}" /></td>
    </tr>
    <tr>
        <td>Vendor Id:</td>
        <td><c:out value="${game.vendorId}" /></td>
    </tr>
</table>
<br><br>
<a href="/">HOME</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/games/viewAllGames">All Games</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/games/addGame">Add New Game</a>
</body>
</html>