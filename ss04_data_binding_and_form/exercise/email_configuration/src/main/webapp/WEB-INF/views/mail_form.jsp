<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<h1>Email Configuration</h1>
<form:form action="/show-result" method="post" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="language">Language</form:label></td>
            <td><form:select path="language" items="${languageList}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page size</form:label></td>
            <td>Show <form:select path="pageSize" items="${pageSizeList}"/> emails per page</td>
        </tr>
        <tr>
            <td>Spams filter </td>
            <td><form:checkbox path="spamsFilter"/> Enable spams filter </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td> </td>
            <table>
                <td><button type="submit">Update</button></td>
                <td><button type="button">Cancel</button></td>
            </table>
        </tr>
    </table>
</form:form>
</body>
</html>