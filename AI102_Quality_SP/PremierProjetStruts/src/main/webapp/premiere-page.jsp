<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Premiere Action avec Struts - AI102 - Struts 1.3</title>
</head>
<body>
	<h1>avec taglib de struts</h1>
	<html:form action="/nimportequoi.php">
		<span>saisie : </span>
		<html:text property="saisie" />
		<html:submit value="Click" />
		<span>${fbPremier.label }</span>
	</html:form>
		<h1>sans taglib de struts</h1>
	<form action="nimportequoi.php" method="post">
		<span>saisie : </span>
		<input type="text" name="saisie" />
		<input type="submit" value="Click" />
		<span>${fbPremier.label }</span>
	</form>
</body>
</html>