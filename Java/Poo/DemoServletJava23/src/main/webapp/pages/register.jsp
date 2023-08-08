<%@ page import="technifutur.be.technifutur.models.entities.UserSimplify" %><%--
  Created by IntelliJ IDEA.
  User: studentdev06
  Date: 08-05-23
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/main.css">
    <link rel="stylesheet" href="styles/normalize.css">

    <title>Title</title>
</head>

<body>
<jsp:include page="../headerOld.jsp" />

<h1>Register</h1>
<form method="post" action="register">
    <label for="login">Login: </label>
    <input type="text" id="login" name="login" value="${login}">
    <label for="password">Password: </label>
    <input type="password" name="password" id="password">
    <label for="email">Email: </label>
    <input type="email" name="email" id="email">
    <button type="submit">Register</button>
</form>
</body>
</html>