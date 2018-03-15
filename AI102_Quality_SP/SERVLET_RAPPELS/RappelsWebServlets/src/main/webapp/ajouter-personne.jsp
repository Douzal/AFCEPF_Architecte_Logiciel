<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" 
	  content="text/html; charset=UTF-8">
<title>Ajout de Personne - AI102 - Rappels</title>
</head>
<body>
	<form action="ajouter.aspx" method="post">
	<span>nom : </span>
	<input name="personne-nom" type="text"/>
	<br />
	<span>prénom : </span>
	<input name="personne-prenom" type="text"/>
	<br />
	<span>mail : </span>
	<input name="personne-email" type="text"/>
	<br />
	<span>naissance : </span>
	<input name="personne-dob" type="text"/>
	<br />
	<span>mot de passe : </span>
	<input name="personne-pwd" type="password"/>
	<br />
	<input type="submit" value="Ajouter" />
	${unMessage }	
	</form>
</body>
</html>