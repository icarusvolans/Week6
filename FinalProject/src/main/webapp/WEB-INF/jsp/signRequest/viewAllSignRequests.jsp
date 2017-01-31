<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<table>
    <c:forEach items="${signRequests}" var="signRequest">
        <tr>
            <td>${signRequest.id}</td>
            <td><c:out value="${signRequest.launchDate}" /></td>
            <td><c:out value="${signRequest.program}" /></td>
            <td><c:out value="${signRequest.department}" /></td>
            <td><div contenteditable><c:out value="${signRequest.deliverable}" /></div></td>
            <td><div contenteditable><c:out value="${signRequest.copy}" /></div></td>
        </tr>
    </c:forEach>
    <button action=“editSignRequest” method=“post” id="save">Save Changes</button>
</table>
