$(function() {
	$("img").css({"width":"100px", "height": "100px","border":"1px solid blue"});
	$("img[title='canard_plastique']").on("click", function() {
		$(this).animate(
			{"width":"+=500px","height":"+=500px","border-width":"+=10px"},
			1000)
			.animate(
			{"width":"-=500px","height":"-=500px","border-width":"-=10px"},
			500);
	});
	$("img[title='canard_wc']").on("click", function() {
		$(this).css({"position":"absolute"});
		$(this).animate(
			{"width":"+=500px","height":"+=500px","border-width":"+=10px"},
			{queue:false, duration:1000})
			.animate(
			{"left":"+=500px"}, 
			{queue:false, duration:1000});
	});
});