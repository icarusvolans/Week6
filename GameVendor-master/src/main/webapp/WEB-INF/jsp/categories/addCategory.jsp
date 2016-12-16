<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
    <h1>Add Category</h1>
    <form:form id="addCategoryForm" commandName="category" method="POST" action="/categories/saveNewCategory">
        <form:label path="categoryTitle">Category Title:</form:label>
        <form:input path="categoryTitle" id="categoryTitle" />
        <br>
        <form:label path="categoryDescription">Category Description:</form:label>
        <form:input path="categoryDescription" id="categoryDescription" />
        <br>
        <input type="submit">
    </form:form>
</body>
</html>