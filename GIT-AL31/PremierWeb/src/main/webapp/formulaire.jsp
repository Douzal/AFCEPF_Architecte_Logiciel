<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="al31_jstl_core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="al31_jstl_fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="al31" uri="http://taglib.al31.afcepf.fr/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><al31:hello /></h1>
<form action="formulaire_jsp.aspx" method="post">
		<span>civilité : </span>
		<span>M.</span>
		<input type="radio" name="form-civilite" value="M."/>
		<span> Mme. </span>
		<input type="radio" name="form-civilite" value="Mme."/>
		<br />
		<span>nom : </span>
		<input type="text" name="form-nom" /><br />
		<span>prénom : </span>
		<input type="text" name="form-prenom" /><br />
		<span>naissance : </span>
		<input type="text" name="form-naissance" /><br />
		<span>activité : </span>
		<select name="form-activite">
			<option value="activité1">Activité 1</option>
			<option value="activité2">Activité 2</option>
			<option value="activité3">Activité 3</option>
			<option value="activité4">Activité 4</option>
			<option value="activité5">Activité 5</option>
		</select><br />
		<span>adresse : </span>
		<textarea rows="5" cols="15" name="form-adresse" ></textarea><br />
		<span>Choix : </span>
		<br />
		<input type="checkbox" name="form-choix" value="choix1" />
		<span>Choix 1</span>
		<br />
		<input type="checkbox" name="form-choix" value="choix2" />
		<span>Choix 2</span>
		<br />
		<input type="checkbox" name="form-choix" value="choix3" />
		<span>Choix 3</span>
		<br />
		<input type="checkbox" name="form-choix" value="choix4" />
		<span>Choix 4</span>
		<br />
		<input type="submit" value="Valider" name="click" />
	</form>
	<%
	if (request.getParameter("click") != null) {
		// affichage des saisies en utilisant les attributs de la Request
	%>
	<span>civilité : <%=request.getAttribute("civilite") %></span><br />
	<span>nom : <%=request.getAttribute("nom") %></span><br />
	<span>prénom : <%=request.getAttribute("prenom") %></span><br />
	<span>naissance : <%=request.getAttribute("naissance") %></span><br />
	<span>adresse : <br /><%=request.getAttribute("adresse") %></span><br />
	<span>activité : <%=request.getAttribute("activite") %></span><br />
	<span>choix : <br />
	<%
	String[] choix = (String[])request.getAttribute("choix");
	if(choix != null) {
		for(String s : choix) {
			out.print(s + "<br />");
		}
	}
	%>
	</span><br />
	<%
	}
	%>
	<hr />
	<h1>Avec Java Standard TagLib</h1>
	<al31_jstl_core:if test="${nom != null }">
		<span>civilité : <al31_jstl_core:out value="civilite" /></span><br />
		<span>nom : ${nom }</span><br />
		<span>prénom : ${prenom }</span><br />
		<span>naissance : ${naissance }</span><br />
		<span>adresse : <br />${adresse }</span><br />
		<span>activité : ${activite }</span><br />
		<span>choix : <br />
		<al31_jstl_core:forEach items="${choix }" var="unchoix">
			<span>${unchoix }</span><br />
		</al31_jstl_core:forEach>
		</span>
	</al31_jstl_core:if>
</body>
</html>