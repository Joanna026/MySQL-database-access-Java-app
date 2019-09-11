<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 8/17/19
  Time: 2:13 PM
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
<form action="/usersform" name="userId" method="POST">
    <input type="hidden" name="userId" value="${userToEdit.id}">
    <h2>${userToEdit.id==0 ? "Nowy użytkownik" : "Edycja użytkownika"}</h2>
    <label>
        Nazwa użytkownika:
        <input type="text" name="name" value="${userToEdit.username}">
    </label>
    <label>
       Adres e-mail:
        <input type="text" name="email" value="${userToEdit.email}">
    </label>
    <label>
        Hasło:
        <input type="text" name="password" value="${userToEdit.password}">
    </label>
    <label>
        Grupa:
        <select name="groupId">
            <c:forEach items="${allGroups}" var="group">
               <c:if test="${group.id==userToEdit.user_group_id}">
                   <option value="group.id" selected>${group.name}</option>
               </c:if>
                <c:if test="${group.id!=userToEdit.user_group_id}">
                    <option value="${group.id}">${group.name}</option>
                </c:if>
<%--                <option ${group.id==userToEdit.user_group_id ? value="group.id" selected : value=group.id}>${group.name}</option>--%>
            </c:forEach>
        </select>
    </label>
    <label>
        <input type="submit" value="OK">
    </label>
</form>
</body>
</html>
