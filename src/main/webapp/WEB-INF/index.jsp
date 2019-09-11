<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 8/10/19
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
<%@ include file="header.jsp"%>
<table>
    <tr>
        <th>Tytuł zadania</th>
        <th>Autor rozwiązania</th>
        <th>Data dodania</th>
        <th>Szczegóły</th>
    </tr>
    <c:forEach items="${solutions}" var="solution">
                <c:url var="loadDetails" value="/showdetails">
                    <c:param name="solutionId" value="${solution[3]}"/>
                </c:url>
        <tr>
                <td>${solution[0]}</td>
                <td>${solution[1]}</td>
                <td>${solution[2]}</td>
            <td><a href='${loadDetails}'>Pokaż</a></td>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp"%>
</body>
</html>
