<%@ page import="technifutur.be.technifutur.models.entities.UserSimplify" %>
<header>
    <a href="index.jsp">Home</a>
    <a href="products">Products</a>
    <a href="songs">Songs</a>
    <%
        if (session.getAttribute("user") != null) {
    %>
    <div>
        <p>Welcome <%= ((UserSimplify) session.getAttribute("user")).getUsername() %>
        </p>
        <a href="disconnect">Disconnect</a>
    </div>
    <%
    } else {
    %>
    <div>
        <a href="login">Login</a>
        |
        <a href="register">Register</a>
    </div>
    <%
        }
    %>
</header>