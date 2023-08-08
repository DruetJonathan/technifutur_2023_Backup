<%--
  Created by IntelliJ IDEA.
  User: studentdev06
  Date: 30-05-23
  Time: 15:06
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
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/main.css">
    <title>GameForm</title>
</head>
<jsp:include page="nav.jsp" />
<body>
<article id="gameArticle">
    <form action="gameForm" method="post" class="gameForm">
        <c:if test="${nameError != null}">
            <span style="color: red">${nameError}</span>
        </c:if>
        <label for="name">Name Of The Game: </label>
        <input type="text" id="name" name="name" value="${name}">
        <input type="hidden" value="create" name="typeOfForm">
        <button type="submit">Create</button>
    </form>
    <form action="gameForm" method="post" class="gameForm">
        <c:if test="${nameErrorModify != null}">
            <span style="color: red">${nameErrorModify}</span>
        </c:if>
        <select name="idGame">
            <c:forEach items="${gameList}" var="game">
                <option value="${game.id}">${game.name}</option>
            </c:forEach>
        </select>
        <label for="nameModify">New name Of The Game: </label>
        <input type="text" id="nameModify" name="nameModify" value="${nameModify}">
        <input type="hidden" value="update" name="typeOfForm">
        <button type="submit">Modify</button>
    </form>
    <form action="gameForm" method="post" class="gameForm">
        <c:if test="${nameErrorDelete != null}">
            <span style="color: red">${nameErrorDelete}</span>
        </c:if>
        <select name="idGame">
            <c:forEach items="${gameList}" var="game">
                <option value="${game.id}">${game.name}</option>
            </c:forEach>
        </select>
        <input type="hidden" value="delete" name="typeOfForm">
        <button type="submit">Delete</button>
    </form>
</article>
</body>
</html>