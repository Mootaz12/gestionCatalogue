<%@page import="java.util.List"%>
<%@page import="dao.entities.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<% List<Produit> liste = (List<Produit>)request.getAttribute("products"); %>
	<div class="container">
	<table class="table">
		<tr>
			<th>#</th>
			<th>Nom</th>
			<th>Prix</th>
			<th>Quantite</th>
		</tr>
		<% for(Produit p:liste){ %>
		<tr>
			<td><%=p.getId() %></td>
			<td><%=p.getNom() %></td>
			<td><%=p.getPrix() %></td>
			<td><%=p.getQuantite() %></td>
		</tr>
		<% } %>
	</table>
	</div>
</body>
</html>