<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 30.03.2019
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<html>
<head>
    <title>Каталог</title>
    <%@ include file="header.jsp" %>
</head>
<body>
<div>
    <ul class="catalog">
<c:forEach var="book" items="${requestScope.books}">
        <li class="product-wrapper">
            <a href="${pageContext.request.contextPath}/book?id=${book.id}" class="product">
                <img src="${pageContext.request.contextPath}${book.img}">
                <p>${book.name}<br></p>
                <p>ЦЕНА: ${book.price} BYN<br></p>
            </a>
        </li>
</c:forEach>
    </ul>
</div>
</body>
</html>
