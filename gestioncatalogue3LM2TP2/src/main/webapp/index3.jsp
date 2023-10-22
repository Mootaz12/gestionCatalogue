<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier le produit</title>
</head>
<body>
<h1>Modifier le produit</h1>
   <form method="post" action="controlleur">
    <label for="id">ID: </label>
    <input type="text" id="id" name="id" value="${id}" readonly>
    <label for="name">Nom: </label>
    <input type="text" id="name" name="name" value="${name}">
    <label for="prix">Prix: </label>
    <input type="number" id="prix" name="prix" value="${prix}">
    <label for="quantities">Quantité: </label>
    <input type="number" id="quantities" name="quantities" value="${quantities}">
    <button type="submit" name="action" value="modifier" class="btn btn-primary mb-2">Modifier</button>
   </form>
</body>
</html>