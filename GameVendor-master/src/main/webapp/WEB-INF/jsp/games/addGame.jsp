<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Game</title>
</head>
<body>
    <h1>Add Game</h1>
    <form:form id="addGameForm" commandName="game" method="POST" action="/games/saveNewGame">
        <form:label path="gameTitle">Game Title:</form:label>
        <form:input path="gameTitle" id="gameTitle" />
        <br>
        <form:label path="gameDescription">Game Description:</form:label>
        <form:input path="gameDescription" id="gameDescription" />
        <br>
        <form:label path="categoryId">Category:</form:label>
        <form:select path="categoryId" id="categoryId">
            <form:options items="${categoryIdAndNameList}" />
        </form:select>
        <br>
        <form:label path="gamePrice">Game Price:</form:label>
        <form:input path="gamePrice" id="gamePrice" />
        <br>
        <form:label path="vendorId">Vendor:</form:label>
        <form:select path="vendorId" id="vendorId">
            <form:options items="${vendorIdAndNameList}" />
        </form:select>
        <br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="submit">
    </form:form>
</body>
</html>