<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Category</title>
</head>
<body>
<h1>View Category</h1>
<br><br>
<table>
    <tr>
        <td>Category Id:</td>
        <td><c:out value="${category.categoryId}" /></td>
    </tr>
    <tr>
        <td>Category Title:</td>
        <td><c:out value="${category.categoryTitle}" /></td>
    </tr>
    <tr>
        <td>Category Description:</td>
        <td><c:out value="${category.categoryDescription}" /></td>
    </tr>
</table>
<br><br>
<a href="/">HOME</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/categories/viewAllCategories">All Categories</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/categories/addCategory">Add New Category</a>
</body>
</html>