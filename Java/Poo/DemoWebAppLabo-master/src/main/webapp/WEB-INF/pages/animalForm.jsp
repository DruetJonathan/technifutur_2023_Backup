<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mon Form</title>
</head>
<body>
    <h1>animalForm work.</h1>
    <form action="../animal/add" method="post">
        <label for="name">Nom : </label>
        <input type="text" id="name" name="name" maxlength="50" value="${name}">
        <c:if test="${nameError != null}">
            <span style="color: red">${nameError}</span>
        </c:if>
        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
