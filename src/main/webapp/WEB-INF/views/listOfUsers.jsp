<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/stindex.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="${pageContext.request.contextPath}/assets/js/test1.js" />"> </script>
</head>
<body>

<table  id ="users" border="1" cellspacing="0" cellpadding="2">
    <caption>Users list</caption>

    <tr>
        <td class="bImg"> login</td>
        <td class="bImg"> delete</td>
    </tr>

    <c:set var="i" value="0"/>
    <c:forEach items="${allUsers}" var="user">
        <c:set var="i" value="${i+1}"/>
        <tr>
            <td>${user.login}</td>
            <c:url var="delete" value="/delete/${user.login}"/>
            <td>
                <form   action="${delete}" method="POST">
                    <input id="dlt"  type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

