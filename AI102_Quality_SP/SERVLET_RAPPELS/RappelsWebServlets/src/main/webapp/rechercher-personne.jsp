<%@page import="java.util.List"%>
<%@page import="fr.afcepf.ai102.qualimetrie.entity.Personne"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recherche de personnes - AI102 - Rappels Servlets</title>
</head>
<body>
	<form action="rechercher.aspx" method="post">
		<span>nom : </span>
		<input type="text" name="recherche-nom" />
		<input type="submit" value="Rechercher" />
	</form>
	<c:if test="${liste != null }">
	<table>
		<thead>
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Mail</th>
			<th>Dob</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="pers" items="${liste }">
		<tr>
			<td>${pers.nom}</td>
			<td>${pers.prenom}</td>
			<td>${pers.mail}</td>
			<td><fmt:formatDate value="${pers.dob}" pattern="dd/MM/yyyy"/> </td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</c:if>
	<%
	if(request.getAttribute("liste") != null) {
	%>
	<table>
		<thead>
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Mail</th>
			<th>Dob</th>
		</tr>
		</thead>
		<tbody>
	<%
	for(Personne pers : (List<Personne>)request.getAttribute("liste")) {
	%>
		<tr>
			<td><%=pers.getNom() %></td>
			<td><%=pers.getPrenom() %></td>
			<td><%=pers.getMail() %></td>
			<td><%=pers.getDob() %></td>
		</tr>
	<%    
	}
	%>
		</tbody>
	</table>
	<%    
	}
	%>
</body>
</html>