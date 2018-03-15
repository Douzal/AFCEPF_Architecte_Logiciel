$(function() {
	$("h1").after("<p>un paragraphe</p>");
	$("#toto").prepend("<h1>Nouveau titre</h1>");
	$("h2").prepend("*** ");
	$("h2").append(" ***");
	$("h3").before("<p>un autre paragraphe</p>");
	$("p").wrapInner("<strong></strong>");
	$("p").wrap("<em></em>");
});