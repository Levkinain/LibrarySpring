<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Irina
  Date: 30.11.2017
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
</head>
<body>
<!--Задаем таблицу пользователей -->
<table border="1" cellspacing="0" cellpadding="2">
<input type="submit" name="add User" value="Delete"/> "/addUser"

<tr>
    <td>INS</td>
    <td class="sort">AUTHOR</td>
    <td>NAME BOOK</td>
</tr>
    <c:forEach items="${library}" var="lib" varStatus="status">
            <tr>
                <td >${lib.book.getINS()}</td>
                <td>${lib.book.getAuthorBook()}</td>
                <td>${lib.book.getNameBook()}</td>
                <!--как корректно передавать параметры в ajax и в модальные окна для динамических элементов-->
            </tr>
    </c:forEach>
</table>
    <!-- Конец-->
<button id="3" class="load" value="Load"> Load 5 books </button>
</body>
    </html>
