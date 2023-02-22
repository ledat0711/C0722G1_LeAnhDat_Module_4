<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 13/10/2022
  Time: 5:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<center>
<div style="border: black solid">
<form action="/list">
    <h1>Ứng dụng từ điển ^^!</h1>
    <p>Nhập một từ tiếng Anh: <input type="text" name="englishWord" placeholder="Nhập tại đây"></p>
    <button type="submit">Dịch</button>
    <p>Kết quả dịch: <br>Tiếng Anh: ${englishWord} <br>Tiếng Việt: <span style="color: red">${answer}</span></p>
</form>
</div>
</center>
</body>
</html>
