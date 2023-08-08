<%@ page import="com.babiarzdruet.labojavadataweb.services.impl.UserServiceImpl" %>
<%@ page import="jakarta.inject.Inject" %>
<%@ page import="com.babiarzdruet.labojavadataweb.models.entities.User" %>
<%@ page import="com.babiarzdruet.labojavadataweb.models.entities.RequestCoaching" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: studentdev06
  Date: 31-05-23
  Time: 14:00
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
    <title>Request Coaching Management</title>
</head>
<jsp:include page="nav.jsp" />
<body>
<article id="requestCoachingArticle">
    <form action="requestCoachingForm" method="post" class="requestCoachingForm">
        <c:if test="${errorCreate != null}">
            <span style="color: red">${errorCreate}</span>
        </c:if>
        <label for="name">Name Of The Request Coaching: </label>
        <input type="text" id="name" name="name" value="${name}">
        <textarea maxlength="250" name="description" placeholder="Describe here..."></textarea>
        <label for="name">Price: </label>
        <input type="number" id="price" name="price" min="0" value="0">
        <input type="hidden" value="<%= session.getAttribute("idUser")%>" id="idUserForm" name="idUserForm">
<%--        <select name="idUserForm">--%>
<%--            <c:forEach items="${userList}" var="user">--%>
<%--                <option value="${user.id}">${user.firstname} ${user.lastname}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
        <select name="idGame">
            <c:forEach items="${gameList}" var="game">
                <option value="${game.id}">${game.name}</option>
            </c:forEach>
        </select>
        <input type="hidden" value="create" name="typeOfForm">
        <button type="submit">Create</button>
    </form>
    <c:forEach var="role" items="${user.roles}">
<%--        todo faire l'affichage des request rent--%>
        <c:if test="${role.name == 'User'}">
            <%
                UserServiceImpl userService = new UserServiceImpl();
                User userNew = userService.getOne((Long) session.getAttribute("idUser"));
                Set<RequestCoaching> requestCoaching = userNew.getRequestCoaching();
            %>
            <h2>My requests</h2>
            <table>
            <thead>
            <tr>
                <th>id</th>
                <th>nom</th>
                <th>description</th>
                <th>price</th>
                <th>game name</th>
                <th>Coach name</th>
            </tr>
            </thead>
            <c:forEach var="requestRenting" items="<%=requestCoaching%>">
                    <c:if test="${requestRenting!= null}">
                                <tr>
                                    <td>${requestRenting.id}</td>
                                    <td>${requestRenting.name}</td>
                                    <td>${requestRenting.description}</td>
                                    <td>${requestRenting.price}</td>
                                    <td>${requestRenting.game.name}</td>
                                    <td>${requestRenting.user.firstname} ${requestRenting.user.lastname}</td>
                                </tr>
                    </c:if>

            </c:forEach>
            </table>

        </c:if>
    <c:if test="${role.name == 'Admin'}">
            <h2>Request in Pending</h2>
            <table>
                <thead>
                <tr>
                    <th>id</th>
                    <th>nom</th>
                    <th>description</th>
                    <th>Statut</th>
                    <th>price</th>
                    <th>game name</th>
                    <th>Coach name</th>
                    <th>
                        button ici
                    </th>
                </tr>
                </thead>
                <c:if test="${applicationScope.requestCoachingList != null}">
                    <c:forEach items="${applicationScope.requestCoachingList}" var="requestCoaching">
                        <c:if test="${requestCoaching.pending}">
                            <tr>
                                <td>${requestCoaching.id}</td>
                                <td>${requestCoaching.name}</td>
                                <td>${requestCoaching.description}</td>
                                <td>${requestCoaching.pending}</td>
                                <td>${requestCoaching.price}</td>
                                <td>${requestCoaching.game.name}</td>
                                <td>${requestCoaching.user.firstname} ${requestCoaching.user.lastname}</td>
                                <td>
                                    <form action="requestCoachingForm" method="post" class="accept">
                                        <input type="hidden" value="pending" name="typeOfForm">
                                        <input type="hidden" value="${requestCoaching.id}" name="id">
                                        <button type="submit">Accept</button>
                                    </form>
                                    <form action="requestCoachingForm" method="post" class="decline">
                                        <input type="hidden" value="delete" name="typeOfForm">
                                        <input type="hidden" value="${requestCoaching.id}" name="id">
                                        <button type="submit">Decline</button>
                                    </form>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </c:if>
            </table>
            <h2>All Request</h2>
            <table>
            <thead>
            <tr>
                <th>id</th>
                <th>nom</th>
                <th>description</th>
                <th>Statut</th>
                <th>price</th>
                <th>game name</th>
                <th>Coach name</th>
                <th>
                    button ici
                </th>
            </tr>
            </thead>
            <c:if test="${applicationScope.requestCoachingList != null}">
                <c:forEach items="${applicationScope.requestCoachingList}" var="requestCoaching">
                    <tr>
                        <td>${requestCoaching.id}</td>
                        <td>${requestCoaching.name}</td>
                        <td>${requestCoaching.description}</td>
                        <td>${requestCoaching.pending}</td>
                        <td>${requestCoaching.price}</td>
                        <td>${requestCoaching.game.name}</td>
                        <td>${requestCoaching.user.firstname} ${requestCoaching.user.lastname}</td>
                        <td>
                            <c:if test="${requestCoaching.pending}">

                                <form action="requestCoachingForm" method="post" class="accept">
                                    <input type="hidden" value="pending" name="typeOfForm">
                                    <input type="hidden" value="${requestCoaching.id}" name="id">
                                    <button type="submit">Accept</button>
                                </form>
                                <form action="requestCoachingForm" method="post" class="decline">
                                    <input type="hidden" value="delete" name="typeOfForm">
                                    <input type="hidden" value="${requestCoaching.id}" name="id">
                                    <button type="submit">Decline</button>
                                </form>
                            </c:if>
                            <c:if test="${!requestCoaching.pending}">
                                <form action="requestCoachingForm" method="post" class="delete decline">
                                    <input type="hidden" value="delete" name="typeOfForm">
                                    <input type="hidden" value="${requestCoaching.id}" name="id">
                                    <button type="submit">Delete</button>
                                </form>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </c:if>
    </c:forEach>


</article>
</body>
</html>