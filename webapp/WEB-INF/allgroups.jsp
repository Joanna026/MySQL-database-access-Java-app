<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 8/12/19
  Time: 9:50 PM
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
        <th>Użytkownicy</th>
    </tr>
<c:forEach items="${allGroups}" var="group">
    <c:url var="allgroups" value="/showusers">
        <c:param name="groupId" value="${group.id}"/>
    </c:url>
    <tr>
        <td>${group.id}</td>
        <td>${group.name}</td>
        <td><a href="${allgroups}">Pokaż listę</a></td>
    </tr>
</c:forEach>
</body>
</html>
