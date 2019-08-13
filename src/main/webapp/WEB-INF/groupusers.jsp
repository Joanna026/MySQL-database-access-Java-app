<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 8/13/19
  Time: 5:48 PM
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
        <th>Nazwa użytkownika</th>
        <th>Szczegóły</th>
    </tr>
    <c:forEach items="${users}" var="user">
    <c:url var="userData" value="/userdata">
        <c:param name="userId" value="${user.id}"/>
    </c:url>
    <tr>
        <td>${user.username}</td>
        <td><a href="${userData}">Pokaż</a></td>
    </tr>
    </c:forEach>
</body>
</html>
