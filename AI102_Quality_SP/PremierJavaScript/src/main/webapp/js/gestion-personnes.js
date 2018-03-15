$(function() {
	$(".corbeille").droppable({
		drop: function(event, ui) {
			$("#message").html($(ui.draggable[0]).attr("id"));
			let id = $(ui.draggable[0]).attr("id").split("-");
			id = id[1];
			let params = "id-pers=" + id;
			$.ajax({
				type:"post",
				contentType:"application/x-www-form-urlencoded",
				url:"supprimer-personne.aspx",
				async:true,
				data:params,
				success:function(data) {
					$("#personne-nom").trigger("keyup");
				}, 
				error:function(data) {
					$("#message").html(data);
				}
			});
		}
	});
	$("#personne-nom").on("keyup", function() {
		let params = "nom=" + $(this).val();
		$.ajax({
			type:"post",
			contentType:"application/x-www-form-urlencoded",
			url:"recherche-personne.aspx",
			async:true,
			data:params,
			success:function(data) {
				$("#tab-personne").html("");
				$("#tab-personne").append(data);
				$(".boite-personne").draggable({
						revert:"invalid",
						start: function() {
							$(this).css({"z-index" : 10, "background-color": "green"});
						},
						stop: function() {
							$(this).css({"z-index" : 0, "background-color": "white"});
						} 
				});
			}, 
			error:function(data) {
				$("#message").html(data);
			}
		});
	});
	$("#form-ajout").on("submit", function() {
		let params = "nom=" + encodeURI($("#personne-nom").val());
		params += "&prenom=" + encodeURI($("#personne-prenom").val());
		params += "&mail=" + encodeURI($("#personne-mail").val());
		params += "&naissance=" + encodeURI($("#personne-naissance").val());
		params += "&password=" + encodeURI($("#personne-password").val());
		$.ajax({
			type:"post",
			contentType:"application/x-www-form-urlencoded",
			url:"ajouter-personne.aspx",
			async:true,
			data:params,
			success:function(data) {
				$("#message").html(data);
			}, 
			error:function(data) {
				$("#message").html(data);
			}
		});
		return false;
	});
});