<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Spring MVC checkbox</title>
</head>

<body>
<h2>Choose your department</h2>

<form:form method="POST" commandName="teamMember">
    <table>
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
        <tr>
            <td><input type="submit" name="submit" value="Submit"></td>
        </tr>
        <tr>
    </table>
</form:form>

</body>
</html>