<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 17/10/2022
  Time: 4:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result:</h1>
<table>
    <c:forEach var="email" items="${emailList}">
        <tr><th>Language</th><td>${email.language}</td></tr>
        <tr><th>PageSize</th><td>${email.pageSize}</td></tr>
        <tr><th>SpamsFilter</th><td>${email.spamsFilter}</td></tr>
        <tr><th>Signature</th><td>${email.signature}</td></tr>
    </c:forEach>
</table>
</body>
</html>