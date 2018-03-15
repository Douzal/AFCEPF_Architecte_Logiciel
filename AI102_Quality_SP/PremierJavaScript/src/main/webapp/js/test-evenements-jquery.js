$(function() {
	$("img").each(function() {
		$(this).attr("alt", $(this).attr("src"));
	});
	$("img").css({width:"100px", height: "100px"});
	$("img").on("mouseover", function() {
		//$("#affichage").html($(this).attr("src"));
		$("#affichage").html("<img class='grande' src='" + $(this).attr("src") + "' />");
		$(".grande").css({width:"600px", height: "600px"});
	});
	$("img").on("click", function() {
		$(this).off("mouseover");
	});
});