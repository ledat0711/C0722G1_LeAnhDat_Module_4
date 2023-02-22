<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 14/10/2022
  Time: 1:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Answer</title>
</head>
<body>
<div style="font-size: 25px;">You ordered a sandwich with the following options:</div>
<c:forEach var="answer" items="${answerList}"><p>${answer}</p></c:forEach>
</body>
</html>