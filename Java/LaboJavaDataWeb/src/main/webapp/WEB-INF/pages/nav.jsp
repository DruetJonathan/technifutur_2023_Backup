<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav>
  <a href="index.jsp"><img src="images/logo-removebg-preview.png" alt="logo" id="logo"></a>
  <div>
    <c:if test="${user == null}">
      <a href="loginForm">Login |</a>
      <a href="registerForm">Register</a>
    </c:if>
    <c:if test="${user != null}">
    <a href="disconnect">Disconnect |</a>
      <a href="#">${user.email}</a>
    </c:if>
  </div>
</nav>