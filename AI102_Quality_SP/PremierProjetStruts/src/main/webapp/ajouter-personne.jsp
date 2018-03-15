<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter une Personne - Ai102 - Struts</title>
</head>
<body>
	<html:form action="/ajouter.php">
		<span>nom : </span>
		<html:text property="pers.nom" /><br />
		<span>prénom : </span>
		<html:text property="pers.prenom" /><br />
		<span>naissance : </span>
		<html:text property="naissance" /><br />
		<span>mot de passe : </span>
		<html:password property="pers.mdp" /><br />
		<span>mail : </span>
		<html:text property="pers.mail" /><br />
		<html:submit value="Ajouter"></html:submit>
		<span>${fbAjouter.message }</span>
	</html:form>
</body>
</html>