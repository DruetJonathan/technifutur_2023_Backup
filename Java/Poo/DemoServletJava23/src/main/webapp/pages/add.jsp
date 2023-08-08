<%--
  Created by IntelliJ IDEA.
  User: studentdev06
  Date: 10-05-23
  Time: 15:06
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
    <title>Add</title>
</head>
<body>
<jsp:include page="../headerOld.jsp"/>
<h1>Add Product</h1>
<form method="post" action="add">
    <label for="libele">Libele: </label>
    <input type="text" id="libele" name="libele">
    <label for="description">Description: </label>
    <textarea id="description" name="description" rows="10" cols="45" style="resize: none"></textarea>
    <label for="price">Price: </label>
    <input type="number" id="price" name="price" step="any">
    <button type="submit">Add Product</button>
</form>
</body>
</html>