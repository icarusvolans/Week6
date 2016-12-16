<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View Games</title>
</head>
<body>
<h1>View Games</h1>
<table>
    <tr>
        <th>Game Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Category ID</th>
        <th>Price</th>
        <th>Vendor ID</th>
    </tr>
    <c:forEach items="${games}" var="game">
        <tr>
            <td><a href="/games/viewGame?gameId=${game.gameId}"><c:out value="${game.gameId}" /></a></td>
            <td><c:out value="${game.gameTitle}" /></td>
            <td><c:out value="${game.gameDescription}" /></td>
            <td><c:out value="${game.categoryId}" /></td>
            <td><c:out value="${game.gamePrice}" /></td>
            <td><c:out value="${game.vendorId}" /></td>
        </tr>
    </c:forEach>
</table>
<br><br>
<a href="/">HOME</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/games/findGame">Find Games</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/games/addGame">Add New Game</a>
</body>
</body>
</html>