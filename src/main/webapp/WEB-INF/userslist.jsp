<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 8/17/19
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<%@ include file="header.jsp"%>
<table cellpadding="1" cellspacing="2" border="1pxsolid">
    <tr>
        <th>Numer id</th>
        <th>Nazwa</th>
        <th>E-mail</th>
        <th>Grupa</th>
        <th></th>
    </tr>
    <c:forEach items="${usersList}" var="user">
        <c:url var="userUpdate" value="/usersform">
            <c:param name="userId" value="${user[0]}"/>
        </c:url>
        <tr>
            <td>${user[0]}</td>
            <td>${user[1]}</td>
            <td>${user[2]}</td>
            <td>${user[3]}</td>
            <td><a href="${userUpdate}">Edytuj</a></td>
        </tr>
    </c:forEach>
</table>

<c:url var="userAdd" value="/usersform">
    <c:param name="userId" value="0"/>
</c:url>
<p><a href="${userAdd}">Dodaj użytkownika</a></p>
</body>
</html>
