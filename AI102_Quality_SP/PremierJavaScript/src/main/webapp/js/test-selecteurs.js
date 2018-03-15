// attendre la disponibilité du DOM
$(function() {
	let nbSpan = $("span").length;
	console.log(nbSpan);
	let nbFooSpan = $("span.foo").length;
	console.log(nbFooSpan);
	let nbFooSpan2 = $("span[class='foo']").length;
	console.log(nbFooSpan2);
	$("#toto").html("texte crée par jQuery<br />");
	$("span.foo").html("encore du texte");
	$("span").css(
		{"color":"red", "font-variant":"small-caps"});
	$("#toto").css({"font-weight" : "bold"});
	$("#images img").css({width:"50px", height:"50px"});
	// tous les canard dont le title contient 'canard'
	$("#images img[title*='canard']")
		.css({border:"2px solid red"});
	// se termine part
	$("#images img[title$='e']")
	.css({width:"100px", height:"100px"});
	// ne contient pas (strict)
	$("#images img[title!='canard_commercial']")
	.css({width:"200px", height:"200px"});
	// tous les canard dont le title comment 'canard'
	$("#images img[title^='bat']")
		.css({border:"10px solid green"});
	console.log($("#images img[title*='canard']:first-child"));
	$("#images img[title*='canard']:first-child")
		.css({transform:"rotate(180deg)"});
	$("#images img[title*='canard']:last-child")
	.css({transform:"rotate(90deg)"});
	$("#images img[title*='canard']:nth-child(3)")
	.css({transform:"rotate(270deg)"});
	$("img + img").css({width:"100px", height:"100px"});
});