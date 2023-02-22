<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Change Money</title>
</head>
<body>
<form action="/change" method="post">
  <input type="number" placeholder="Enter USD here" name="usd"><br><br>
  <button type="submit">Start Change</button>
</form>
<p>VND : ${answer}</p>
</body>
</html>