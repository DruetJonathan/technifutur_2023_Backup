<%@ page import="technifutur.be.technifutur.models.entities.UserSimplify" %>
<%@ page import="technifutur.be.technifutur.models.entities.Song" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: studentdev06
  Date: 09-05-23
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Songs</title>
    <link rel="stylesheet" href="styles/main.css">
    <link rel="stylesheet" href="styles/normalize.css">


</head>
<body>
<jsp:include page="../headerOld.jsp" />

<h1>Songs</h1>
<section>
<%--    <%List<Song> songList = (List<Song>) request.getAttribute("songs");%>--%>
    <c:forEach items="${songs}" var="song">
        <div class="songsDiv">
            <h3>${song.libele}</h3>
            <audio controls src="${song.emplacement_link}"></audio>
        </div>
    </c:forEach>
</section>
</body>
</html>