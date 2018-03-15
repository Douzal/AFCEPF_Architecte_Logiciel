<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${message != null }"><p>${message }</p></c:if>
<c:if test="${liste != null }">
	<c:forEach items="${liste }" var="pers">
		<div class="boite-personne" id="pers-${pers.id }">
			<div class="boite-personne-titre">
			${pers.nom }
			</div>
			<div class="boite-personne-contenu">
			${pers.prenom }<br />
			<fmt:formatDate value="${pers.dob }" pattern="dd/MM/yyyy"/>
			<br />
			${pers.mail }
			</div>
			<div class="boite-personne-footer">
				<input type="button" value="delete" id='pers-${pers.id }' 
				class="btn-delete"/>
			</div>
		</div>		
	</c:forEach>
</c:if>