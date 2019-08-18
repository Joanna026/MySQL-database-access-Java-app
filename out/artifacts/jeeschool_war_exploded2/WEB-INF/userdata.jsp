<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 8/13/19
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dane użytkownika ${user.username}</h2>
<p>Nazwa: ${user.username}</p>
<p>Adres e-mail: ${user.email}</p>
<p>Grupa: ${groupName}</p>
<br/>
<h3>Rozwiązania użytkownika</h3>
<table cellpadding="1" cellspacing="2" border="1pxsolid">
    <tr>
        <th>Nazwa zadania</th>
        <th>Data dodania</th>
        <th>Szczegóły rozwiązania</th>
    </tr>
    <c:forEach items="${userSolutions}" var="solution">
        <c:url var="solutionDetails" value="/showdetails">
            <c:param name="solutionId" value="${solution[2]}"/>
        </c:url>
        <tr>
            <td>${solution[0]}</td>
            <td>${solution[1]}</td>
            <td><a href="${solutionDetails}">Pokaż</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
