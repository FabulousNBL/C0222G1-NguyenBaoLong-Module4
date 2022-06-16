<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 16/06/2022
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="mailBox" method="post" action="/create">
    <label>Language</label>

    <form:select type="text" path="language">
        <form:options items="${language}"></form:options>
    </form:select><br><br>

    <label>Page size</label>

    <p>Show <form:select type="text" path="pageSize">
    <form:options items="${pageSize}"></form:options>
    </form:select> emails per page</p>

    <label>Spams filter:</label>

    <form:checkbox path="spam"></form:checkbox><br><br>

    <label>Signature:</label>

    <form:textarea path="signature"></form:textarea>

    <br>
    <br>

    <button type="submit">Update</button>
    <button><a href="create">Cancel</a></button>
</form:form>
</body>
</html>
