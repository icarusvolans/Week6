<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#190094367412823486 .delete").click(function(){
            <%--$("#${signRequest.id} .delete").click(function(){--%>

                $(this).next('p').toggle();
                $(this).text(function(i, text){
                    return text === "Undo" ? "Delete" : "Undo";
                })
            });
            $("#190094367412823486 textarea").on('keyup',function() {
                $("#190094367412823486 .edit").show();
                <%--$("#${signRequest.id} .edit").show(); --%>


            })

/*            function myFunction() {
                var x = document.getElementById(".copy").value;
                document.getElementById("demo").innerHTML = x;

 onclick="myFunction()"
            }*/

        });
    </script>
    <style>
        p {
            display: none;
        }
    </style>
</head>




<html>
<body>
<%--<button class="edit" style="display:none" type="submit">Save Changes</button>--%>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    </c:if>

</div>
<c:forEach items="${signRequests}" var="signRequest" >
    <form:form method="post"  id="${signRequest.id}" action="${contextPath}/editSignRequest" commandName="editRequest" modelAttribute="signRequest" class="form-signRequests">
        <table>
        <tr>
            <td><input path="launchDate" value="${signRequest.launchDate}" readonly/></td>
            <td><input path="program" value="${signRequest.program}" readonly/></td>
            <td><input path="department" value="${signRequest.department}" readonly/></td>
            <td><textarea style="resize:none" name="deliverable" cols="30" rows="8">${signRequest.deliverable}</textarea></td>
            <td><textarea style="resize:none" id="copy" name="copy" cols="30" rows="8">${signRequest.copy}</textarea></td>
            <%--<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>--%>
            <%--<td><button class="delete">Delete</button>--%>
                <%--<p class="deleteItem">Item Deleted.</p>--%>
            <%--</td>--%>
            <td><button class="edit" type="submit">Save Changes</button></td>
            <%--<td><button class="edit" style="display:none" type="submit">Save Changes</button></td>--%>

            <td><p id="demo"></p></td>
        </tr>
        </table>
    </form:form>
</c:forEach>

<%--<table>
    <c:forEach items="${signRequests}" var="signRequest">
        <tr>
            <td hidden>${signRequest.id}</td>
            <td><c:out value="${signRequest.launchDate}" /></td>
            <td><c:out value="${signRequest.program}" /></td>
            <td><c:out value="${signRequest.department}" /></td>
            <td><div contenteditable><c:out value="${signRequest.deliverable}"/></div></td>
            <td><div contenteditable><c:out value="${signRequest.copy}" /></div></td>
            <td><button action=“editSignRequest” method=“post” id="save">Save Changes</button></td>
        </tr>
    </c:forEach>
</table>--%>

</body>
</html>
