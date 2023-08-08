<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="technifutur.be.technifutur.models.entities.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="technifutur.be.technifutur.models.entities.UserSimplify" %><%--
  Created by IntelliJ IDEA.
  User: studentdev06
  Date: 09-05-23
  Time: 09:02
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
    <script src="fonctionsFile.js"></script>
    <title>Products</title>
</head>
<body>
<jsp:include page="../headerOld.jsp"/>
<h1>Products</h1>
<section>
<%--    <c:if test="${user != null}">--%>
<%--        <form method="get" action="add" class="productForm">--%>
<%--            <button type="submit" id="add">Add Product</button>--%>
<%--        </form>--%>
<%--    </c:if>--%>
    <c:if test="${user != null}">
        <button onclick="functionButtonForm()" id="showAddForm">Add Product</button>
        <article id="articleAddForm">
            <div id="addForm">
                <h1>Add Product</h1>
                <button onclick="functionButtonForm()" id="CloseCross">❌</button>
                <form method="post" action="add">
                    <label for="libele">Libele: </label>
                    <input type="text" id="libele" name="libele">
                    <label for="description">Description: </label>
                    <textarea id="description" name="description" rows="10" cols="45" style="resize: none"></textarea>
                    <label for="price">Price: </label>
                    <input type="number" id="price" name="price" step="any">
                    <button type="submit">Add Product</button>
                </form>
            </div>
        </article>
    </c:if>
    <article id="articleProd">
        <c:forEach items="${products}" var="product">
            <div>
                <h3>${product.libele}</h3>
                <p>${product.description}</p>
                <span>${product.price} €</span>
                <c:if test="${user != null}">
                    <div class="divProduct">
                        <form method="post" action="delete" class="productForm">
                            <input type="hidden" name="id" value="${product.id}">
                            <button type="submit" id="delete">Delete</button>
                        </form>
                        <form method="get" action="modify" class="productForm">
                            <input type="hidden" name="id" value="${product.id}">
                            <button type="submit" id="modify">Modify</button>
                        </form>
                    </div>
                </c:if>
            </div>
        </c:forEach>
    </article>
</section>
</body>
</html>