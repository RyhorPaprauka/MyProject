<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 30.03.2019
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<html>
<div class="top-container">
    <img src="${pageContext.request.contextPath}/img/logo.jpg">
</div>
<div class="admin-menu">
    <li><a href="">Заказы</a></li>
    <li><a href="">Добавить книгу</a></li>
    <li><a href="">Администраторы</a></li>
    <li><a href="">Черный список</a></li>
</div>
<div class="user-menu">
    <li><a href="${pageContext.request.contextPath}/">ГЛАВНАЯ</a></li>
    <li><a href="${pageContext.request.contextPath}/catalog">КАТАЛОГ</a></li>
    <li><a href="">МОЯ КОРЗИНА</a></li>
    <li><a href="">ВЫХОД</a></li>
</div>
</html>
