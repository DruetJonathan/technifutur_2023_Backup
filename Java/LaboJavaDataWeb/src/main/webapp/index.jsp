<%@ page import="com.babiarzdruet.labojavadataweb.models.entities.UserSimplify" %>
<%@ page import="com.babiarzdruet.labojavadataweb.services.impl.RequestCoachingServiceImpl" %>
<%@ page import="com.babiarzdruet.labojavadataweb.models.entities.RequestCoaching" %>
<%@ page import="java.util.List" %>
<%@ page import="jakarta.inject.Inject" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/main.css">

</head>

<body>
<%--    <jsp:include page="WEB-INF/pages/header.jsp" />--%>
<header>
    <jsp:include page="WEB-INF/pages/nav.jsp"/>
    <video autoplay>
        <source src="videos/headerVideo.mp4" type="video/mp4">
        Your browser does not support the video tag.
    </video>
</header>
<section>
    <div id="linkDIV">
    <c:if test="${user != null}">
        <c:forEach var="role" items="${user.roles}">
            <c:if test="${role.name == 'Admin'}">
                <a href="gameForm" class="gameMngmnt">Game Management</a>
            </c:if>
            <c:if test="${role.name == 'User'}">
                <a href="requestCoachingForm" class="requestCoachingMngmnt">Request Coaching Management</a>
            </c:if>
        </c:forEach>
    </c:if>
    </div>
    <%

    %>
    <div id="cardDIV">
    <c:if test="${applicationScope.requestCoachingList != null}">
        <c:forEach items="${applicationScope.requestCoachingList}" var="requestCoaching">
            <c:if test="${!requestCoaching.pending}">
                <div class="card-body">
                    <div class="card-image" style="background-image: url('./images/${requestCoaching.image}')">
                        <span class="card-price">${requestCoaching.price} €</span>
                    </div>
                    <h2 class="card-title">${requestCoaching.name}</h2>
                    <h2 class="card-title">${requestCoaching.game.name}</h2>
                    <h2 class="card-title">${requestCoaching.user.firstname} ${requestCoaching.user.lastname}</h2>
                    <p class="card-description">
                            ${requestCoaching.description}
                    </p>
                    <div class="card-buttonDiv">
                            <%--                todo faire un c:if pour verif si admin--%>
<%--                        <form action="requestCoachingForm" method="post" class="delete">--%>
<%--                            <input type="hidden" value="rent" name="typeOfForm">--%>
<%--                            <input type="hidden" value="${requestCoaching.id}" name="id">--%>
<%--                            <button type="submit">Rent</button>--%>
<%--                        </form>--%>
                        <c:if test="${user != null}">
                            <c:forEach var="role" items="${user.roles}">
                                <c:if test="${role.name == 'Admin'}">
                                    <%--                                    <form action="#" method="post" class="button2">--%>
                                    <%--                                        <button type="submit">Modify</button>--%>
                                    <%--                                    </form>--%>
                                    <%--                                    <form action="#" method="post" class="button3">--%>
                                    <%--                                        <button type="submit">Delete</button>--%>
                                    <%--                                    </form>--%>
                                    <form action="requestCoachingForm" method="post" class="delete">
                                        <input type="hidden" value="delete" name="typeOfForm">
                                        <input type="hidden" value="${requestCoaching.id}" name="id">
                                        <button type="submit">Delete</button>
                                    </form>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </c:if>
    </div>
</section>
</body>
</html>