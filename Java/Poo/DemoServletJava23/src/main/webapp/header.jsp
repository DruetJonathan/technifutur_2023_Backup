<%@ page import="technifutur.be.technifutur.models.entities.UserSimplify" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
    <a href="index.jsp">Home</a>
    <a href="products">Products</a>
    <a href="songs">Songs</a>
    <c:if test="${user != null}">
        <div>
            <p>Welcome <%= ((UserSimplify) session.getAttribute("user")).getUsername() %>
            </p>
            <a href="disconnect">Disconnect</a>
        </div>
    </c:if>
    <c:if test="${user == null}">
        <div>
            <a href="login">Login</a>
            |
            <a href="register">Register</a>
        </div>
    </c:if>
</header>
