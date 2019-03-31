<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 30.03.2019
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<html>
<head>
    <title>${requestScope.book.name}</title>
    <%@ include file="header.jsp" %>
</head>
<body>
<div class="info-container">
    <h1>${requestScope.book.name}</h1>
    <img src="${pageContext.request.contextPath}${requestScope.book.img}">
    <p class="price">Цена ${requestScope.book.price}</p>
</div>
</body>
</html>
