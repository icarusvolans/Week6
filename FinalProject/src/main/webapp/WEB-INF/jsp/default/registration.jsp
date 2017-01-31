<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Registration Form</title>
</head>
<body>
<h1>
    Register here:
</h1>
<form:form modelAttribute="teamMember" method="POST" enctype="utf8">
    <br>
    <tr><td>
        <label>First Name</label>
    </td>
        <td><form:input path="firstName" value="" /></td>
        <form:errors path="firstName" element="div"/>
    </tr>
    <tr><td>
        <label>Last Name</label>
    </td>
        <td><form:input path="lastName" value="" /></td>
        <form:errors path="lastName" element="div" />
    </tr>
    <tr><td>
        <label>Email</label>
    </td>
        <td><form:input path="email" value="" /></td>
        <form:errors path="email" element="div" />
    </tr>
    <tr><td>
        <label>Password</label>
    </td>
        <td>
            <form:input path="password" value="" type="password" /></td>
        <form:errors path="password" element="div" />
    </tr>
    <tr><td>
        <label>Confirm Password</label>
    </td>
        <td><form:input path="matchingPassword" value="" type="password" /></td>
        <form:errors element="div" />
    </tr>
    <tr>
        <td>Choose your Store:</td>
        <td><form:select path="storeName">
            <form:option value="" label="...." />
            <form:options items="${storeNames}" />
        </form:select>
        </td>
        <td><form:errors path="storeName" cssStyle="color: #ff0000;" /></td>
    </tr>
    <tr>
        <td>Choose department(s):</td>
        <td><form:checkboxes path="departments" items="${departments}" />
        </td>
    </tr>
    <button type="submit">Register</button>
</form:form>
<br>
<a href="login" />Login</a>
</body>
</html>
