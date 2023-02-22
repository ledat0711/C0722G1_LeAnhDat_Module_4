<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 14/10/2022
  Time: 11:06 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Option Sandwich</title>
</head>
<body>
<p>Our sandwich shop has the following options: </p>
<form action="/display">
    <c:forEach var="eachOption" items="${optionList}">
        <p><input type="checkbox" name="optionSelected" value="${eachOption}">${eachOption}</p>
    </c:forEach>
    <button type="submit">Save</button>
</form>
</body>
</html>