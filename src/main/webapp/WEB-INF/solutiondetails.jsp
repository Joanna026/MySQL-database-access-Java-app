<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 8/12/19
  Time: 11:25 AM
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
<h3>Rozwiązanie zadania:</h3>
<c:out value="${solution.description}" default="Brak rozwiązania" escapeXml="false"/>

</body>
</html>
