<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13/06/2022
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/change" method="post">
    <input name="usd" type="text" placeholder="USD" value="${usd}">
    <input type="text" readonly value="${total}">

    <button type="submit">Exchange</button>
</form>
</body>
</html>
