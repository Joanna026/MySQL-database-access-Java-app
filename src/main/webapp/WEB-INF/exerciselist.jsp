<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 8/18/19
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table cellpadding="1" cellspacing="2" border="1pxsolid">
<tr>
    <th>Numer id</th>
    <th>Nazwa</th>
    <th>Treść zadania</th>
    <th></th>
</tr>
<c:forEach items="${exerciseList}" var="exercise">
    <c:url var="exerciseUpdate" value="/exerciseform">
        <c:param name="exerciseId" value="${exercise.id}"/>
    </c:url>
    <tr>
        <td>${exercise.id}</td>
        <td>${exercise.title}</td>
        <td>${exercise.description}</td>
        <td><a href="${exerciseUpdate}">Edytuj</a></td>
    </tr>
</c:forEach>
</table>

<c:url var="exerciseAdd" value="/exerciseform">
    <c:param name="exerciseId" value="0"/>
</c:url>
<p><a href="${exerciseAdd}">Dodaj zadanie</a></p>

</body>
</html>
