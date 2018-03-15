$(document).ready(function() {
	
	$("#btnRDV").on("click", function() {
		$("#output-rdv").css({display: 'block'});
		$("#output-event").css({display: 'none'});
	});
	$("#btnEvent").on("click", function() {
		$("#output-event").css({display: 'block'});
		$("#output-rdv").css({display: 'none'});
	});
});
