<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 29.03.2019
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <label for="login">Логин:
        <input id="login" type="text" name="login">
    </label><br>
    <label for="password">Пароль:
        <input id="password" type="password" name="password">
    </label><br>
    <label for="name">Ваше имя:
        <input id="name" type="text" name="name">
    </label><br>
    <label for="mail">E-mail:
        <input id="mail" type="text" name="mail">
    </label><br>
    <label for="address">Адрес:
        <input id="address" type="text" name="address">
    </label><br>
    <label for="phone">Телефон:
        <input id="phone" type="text" name="phone">
    </label><br>
    <input type="submit" value="Зарегестрироваться">
</form>
</body>
</html>
