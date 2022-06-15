<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/06/2022
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<center>
    <form action="/calculate" method="post">
        <h1>Calculator</h1>

        <input type="text" name="number1" value="${number1}">
        <input type="text" name="number2" value="${number2}">
        <br>
        <br>
        <button name="operator" value="+" type="submit">Addition(+)</button>
        <button name="operator" value="-" type="submit">Subtraction(-)</button>
        <button name="operator" value="*" type="submit">Multiplication(*)</button>
        <button name="operator" value="/" type="submit">Division(/)</button>
        <br>
        <br>

    </form>
    Result:<p>${result}</p>
</center>
</body>
</html>
