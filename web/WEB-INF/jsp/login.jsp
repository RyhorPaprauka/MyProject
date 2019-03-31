<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.03.2019
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <div align="middle">
        <img src="${pageContext.request.contextPath}/img/logo.jpg" width="300" height="90" alt="лого">
    </div>
</head>
<body>
<div align="middle">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <c:if test="${param.success}">
            <span style="color: green">Регистрация прошла успешно.Можете войти</span><br>
        </c:if>
        <label for="username">Username:
            <input id="username" type="text" name="username" value="${param.username}">
        </label><br>
        <c:if test="${param.error}">
            <span style="color: red">Вы ввели некорректные данные</span><br>
        </c:if>
        <label for="password">Password:
            <input id="password" type="password" name="password">
        </label><br>
        <input type="submit" value="Login">
        <a href="${pageContext.request.contextPath}/registration">Зарегестрироваться</a><br>
    </form>
</div>
</body>
</html>
