<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 8/18/19
  Time: 12:19 PM
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
<form action="/exerciseform" name="exerciseId" method="POST">
    <input type="hidden" name="exerciseId" value="${exerciseToEdit.id}">
    <h2>${exerciseToEdit.id==0 ? "Nowe zadanie" : "Edycja zadania"}</h2>
   <p><label>
        Tytuł:
        <input type="text" name="name" value="${exerciseToEdit.title}">
   </label></p>
    <p><label>
        Treść zadania:
        <input type="text" name="description" value="${exerciseToEdit.description}">
    </label></p>

    <p><input type="submit" value="OK"></p>
</form>
</body>
</html>
