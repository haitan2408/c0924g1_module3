<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 24/12/2024
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sum" method="post">
    Số thứ nhất: <input name="num1">
    Số thứ hai: <input name="num2">
    <input type="submit" value="Tính tổng">
</form>
<p>${sum}</p>
</body>
</html>
