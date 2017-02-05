<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $(".delete").click(function(){
                $(this).nextAll('p').toggle();
                $(this).text(function(i, text){
                    return text === "Undo" ? "Delete" : "Undo";
                })
            });
            $("textarea").on('keyup',function() {
                $(".edit").show();
//                $( ".edit" ).first().show();

//                $(this).next(".edit").show();


            })

/*            function myFunction() {
                var x = document.getElementById(".copy").value;
                document.getElementById("demo").innerHTML = x;
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
<c:forEach items="${signRequests}" var="signRequest" >
    <form:form method="post" class="form-signRequests">
        <table>
        <tr>
            <td><input path="launchDate" value="${signRequest.launchDate}" readonly/></td>
            <td><input path="program" value="${signRequest.program}" readonly/></td>
            <td><input path="department" value="${signRequest.department}" readonly/></td>
            <td><textarea style="resize:none" path="deliverable" cols="30" rows="8">${signRequest.deliverable}</textarea></td>
            <td><textarea style="resize:none" id="copy" path="copy" cols="30" rows="8">${signRequest.copy}</textarea></td>
            <td><hidden path="id" value="${signRequest.id}"/></td>
            <td><button class="delete">Delete</button>
                <p class="deleteItem">Item Deleted.</p>
            </td>
            <td><button class="edit" style="display:none" onclick="myFunction()" >Save Changes</button></td>
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
