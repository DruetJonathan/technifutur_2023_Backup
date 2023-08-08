<%@ page import="technifutur.be.technifutur.models.entities.Product" %><%--
  Created by IntelliJ IDEA.
  User: studentdev06
  Date: 10-05-23
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="styles/main.css">
    <title>Modify</title>
</head>
<body>
<%
    Product product = (Product) request.getAttribute("product");
%>
<jsp:include page="../headerOld.jsp"/>
<h1>Modification</h1>
<form method="post" action="modify">
    <label for="libele">Libele: </label>
    <input type="text" id="libele" name="libele" value="<%= product.getLibele()%>">
<%--    <%--%>
<%--        request.setAttribute("id",product.getId());--%>
<%--    %>--%>
    <input type="hidden" name="id" value="<%= product.getId()%>">
    <label for="description">Description: </label>
    <textarea id="description" name="description" rows="10" cols="45" style="resize: none"><%= product.getDescription()%></textarea>
    <label for="price">Price: </label>
    <input type="number" id="price" name="price" value="<%= product.getPrice()%>" step="any">
    <button type="submit">Modify</button>
</form>
</body>
</html>