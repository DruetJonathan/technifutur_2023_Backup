<%--
  Created by IntelliJ IDEA.
  User: studentdev06
  Date: 26-05-23
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<jsp:include page="nav.jsp" />

<article id="loginArticle">
    <form action="loginForm" method="post" id="loginForm">
        <c:if test="${loginError != null}">
            <span style="color: red">${loginError}</span>
        </c:if>
        <label for="email">Email: </label>
        <input type="email" id="email" name="email" value="${email}">
        <label for="password">Password: </label>

        <input type="password" id="password" name="password" value="${password}">
        <button type="submit">Login</button>
        <a href="registerForm">Sign In</a>
    </form>
</article>
</body>
</html>