<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 8/15/19
  Time: 9:00 PM
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
<form  action="/groupform" name="groupId"  method="POST" >
    <input type="hidden" name="groupId" value="${groupToEdit.id}">
    <h2>${groupToEdit.id==0 ? "Nowa grupa" : "Edycja grupy"}</h2>
    <label>
       ${groupToEdit.id==0 ? "Nazwa nowej grupy:" : "Nowa nazwa grupy:"}
    <input type="text" name="name" value="${groupToEdit.name}" >
    </label>
</form>

</body>
</html>
