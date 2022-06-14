
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
