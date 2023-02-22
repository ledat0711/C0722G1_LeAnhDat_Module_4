<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 14/10/2022
  Time: 2:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/work" method="post">
    <input type="number" name="firstNum" placeholder="Enter a number" required>
    <input type="number" name="secondNum" placeholder="Enter a number" required>
    <button type="submit" value="+" name="action">Addition</button>
    <button type="submit" value="-" name="action">Subtraction</button>
    <button type="submit" value="*" name="action">Multiplication</button>
    <button type="submit" value="/" name="action">Division</button>
</form>
<p>Answer: ${answer}</p>
</body>
</html>
