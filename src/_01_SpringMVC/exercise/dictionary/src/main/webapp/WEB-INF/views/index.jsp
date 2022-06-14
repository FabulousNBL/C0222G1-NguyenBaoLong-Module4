<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="trans" method="post">
    <input name="word" type="text" placeholder="Nhập từ muốn tìm kiếm" value="${findWord}">
    <input type="text" readonly value="${trans}">

    <button type="submit">Translate</button>
</form>
</body>
</html>
