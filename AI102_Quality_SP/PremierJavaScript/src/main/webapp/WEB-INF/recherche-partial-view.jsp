<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${message != null }"><p>${message }</p></c:if>
<c:if test="${liste != null }">
<table style="width:100%">
	<thead>
		<tr><th>Nom</th><th>Prénom</th><th>Mail</th><th>Naissance</th></tr>
	</thead>
	<tbody>
	<c:forEach items="${liste }" var="pers">
		<tr><td>${pers.nom }</td><td>${pers.prenom }</td><td>${pers.mail }</td>
			<td><fmt:formatDate value="${pers.dob }" pattern="dd/MM/yyyy"/></td>		
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
		<tr><th colspan="4">nombre de personne(s) : 
			<c:out value="${fn:length(liste) }"></c:out>
			</th>
		</tr>
	</tfoot>
</table>
</c:if>