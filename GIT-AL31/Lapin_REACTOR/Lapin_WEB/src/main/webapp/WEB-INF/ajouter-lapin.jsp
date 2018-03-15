<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
    <jsp:directive.page language="java"
        contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
    </jsp:text>
<html xmlns="http://www.w3.org/1999/xhtml"
	  xmlns:al31="http://taglib.al31.afcepf.fr/tags">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ajouter des Lapins - AL31 - JEE</title>
</head>
<body>
	<form action="ajouter-lapin.cretin" method="post">
	<span>nom : </span>
	<input type="text" name="lapin-nom" /><br />
	<span>couleur : </span>
	<input type="text" name="lapin-couleur" /><br />
	<span>oreilles : </span>
	<input type="number" name="lapin-oreille" /><br />
	<span>naissance : </span>
	<input type="text" name="lapin-naissance" /><br />
	<span>sexe : </span>
	<input type="radio" checked="true" name="lapin-sexe" value="H"/> M.
	<input type="radio" name="lapin-sexe" value="F"/> F.
	<br />
	<al31:clapiers />
	<input type="submit" name="lapin-ajouter" value="Ajouter" />
	</form>
	${message }
</body>
</html>
</jsp:root>