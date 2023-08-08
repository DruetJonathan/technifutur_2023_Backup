<%--
  Created by IntelliJ IDEA.
  User: studentdev06
  Date: 25-05-23
  Time: 14:55
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
    <title>Register</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<article id="registerArticle">

    <form action="registerForm" method="post" enctype='multipart/form-data' id="registerForm">
        <label for="firstname">Firstname: </label>
        <c:if test="${firstNameError != null}">
            <span style="color: red">${firstNameError}</span>
        </c:if>
        <input type="text" id="firstname" maxlength="50" name="firstname" value="${firstname}">

        <label for="lastname">Lastname: </label>
        <c:if test="${lastNameError != null}">
            <span style="color: red">${lastNameError}</span>
        </c:if>
        <input type="text" id="lastname" maxlength="50" name="lastname" value="${lastname}">

        <label for="email">Email: </label>
        <c:if test="${emailError != null}">
            <span style="color: red">${emailError}</span>
        </c:if>
        <input type="email" id="email" name="email" value="${email}">

        <label for="password">Password: </label>
        <c:if test="${passwordError != null}">
            <span style="color: red">${passwordError}</span>
        </c:if>
        <input type="password" id="password" name="password" value="${password}">

        <label for="confirmpassword">Confirm password: </label>
        <c:if test="${nameError != null}">
            <span style="color: red">${nameError}</span>
        </c:if>
        <input type="password" id="confirmpassword" name="confirmpassword" value="${confirmpassword}">

        <label>Choose an image for your profile:</label>
        <%--    todo fix ce message--%>
        <%--    <c:if test="${imageProfileError != null}">--%>
        <%--        <span style="color: red">entrez une image</span>--%>
        <%--    </c:if>--%>
        <input type="file" name="profileImage" accept="image/png, image/jpeg, image/jpg" required/>
        <button type="submit">Register</button>
        <a href="loginForm">Already register</a>

    </form>
</article>
</body>
</html>