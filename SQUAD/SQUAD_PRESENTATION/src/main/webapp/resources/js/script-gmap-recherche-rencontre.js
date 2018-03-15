var map;
var infowindow;
var markers = [];

function initAutocomplete() {

	console.log("initmap");

	map = new google.maps.Map(document.getElementById('map'), {
		center: {lat: 48.862000, lng: 2.333669},
		zoom: 12,
		disableDefaultUI: true,
		mapTypeControlOptions: {
			mapTypeIds: []
		},
		styles: [{featureType: "poi",
			elementType: "labels",
			stylers: [{ visibility: "off" }]
		}],
		mapTypeId: 'roadmap'
	});

	var options = {
			types: ['(regions)'],
			componentRestrictions: {country: "fr"}
	};

	infowindow = new google.maps.InfoWindow();


	var input = document.getElementById('input_rechercheRencontre\:inputVille');
	var inputSport = document.getElementById('input_rechercheRencontre\:inputSport');
	var inputDate = document.getElementById('rechercheRencontre\:inputDate_Input');
	var search = document.getElementById('rechercheRencontre\:search');
	var searchBox = new google.maps.places.Autocomplete(input,options);

	map.addListener('bounds_changed', function() {
		searchBox.setBounds(map.getBounds());


		//map.refresh();

	});



	//DEBUT EVENT Recherche sur une nouvelle ville ****
	$(search).on('click', function() {

		if(searchBox.getPlace() != undefined) {

			var infosVille ;

			var place = searchBox.getPlace();
			
			markers.forEach(function(marker) {
				marker.setMap(null);
			});

			//clear marker + div infos
			markers = [];
			$("#listeRencontres").html("");

			if (!place.geometry) {
				window.alert("No details available for input: '" + place.name + "'");
				return;
			}

			if (place.geometry.viewport) {
				map.fitBounds(place.geometry.viewport);
			} else {
				map.setCenter(place.geometry.location);
				map.setZoom(15);
			}

			infosVille = recupInfosVille(place);

			rechercherRencontres(infosVille);

		}else{

			markers.forEach(function(marker) {
				marker.setMap(null);
			});

			//clear marker + div infos
			markers = [];
			$("#listeRencontres").html("");

			console.log("probleme");
			rechercherRencontres();
		}


	});

	//premier affichage
	rechercherRencontres();
}

function rechercherRencontres(infosVille) {

	var listeRencontres = recupererRencontres(infosVille);

	listeRencontres(function (data) {

		console.log(data);

		var rencontres = data.rencontres;

		for(i=0; i < rencontres.length; i++ ) {
			afficherMarker(rencontres[i]);
		}
	});
}
//retourne methode success @liste des terrains (IDF) pour une ville donnée
function recupererRencontres(infosVille) {
	var defaultParams = {};
	var ville = (infosVille == undefined || infosVille == null)?undefined:infosVille.locality;
	var sport =  $("#input_rechercheRencontre\\:inputSport").val();
	var date = $("#rechercheRencontre\\:inputDate_Input").val();

	if(ville != "" && ville != undefined) {
		defaultParams["ville"] = ville;
	}

	if(sport != "" && sport != undefined) {
		defaultParams["sport"] = sport;
	}

	if(date != "" && date != undefined) {
		defaultParams["date"] = date;
	}

	var req = $.ajax({
		type:"POST",
		contentType:"application/x-www-form-urlencoded",
		url:"rechercheRencontre",
		async:true,
		data:defaultParams
	});

	return req.success;
}

function afficherMarker(rencontre) {

	var point = {lat:rencontre.adresseLat,lng:rencontre.adresseLong};

	var marker = new google.maps.Marker({
		position: point,
		animation: google.maps.Animation.DROP,
		map: map,
	});

	marker.anguille = rencontre;

	afficherInfosTerrain(marker);

	google.maps.event.addListener(marker, 'click', function() {
		infowindow.setContent(rencontre.libelle);
		infowindow.open(map, this);

		map.setCenter({lat: marker.anguille.adresseLat, lng: marker.anguille.adresseLng});
		map.setZoom(15);

		clearMarkerStyle();

		$("#"+marker.anguille.id).css({"background-color" : "whitesmoke"});

	});

	$("#"+marker.anguille.id).click(function() {
		google.maps.event.trigger(marker,'click');
	})

	markers.push(marker);
}

function clearMarkerStyle() {
	$('.defautRencontre').css({"border" : "1px solid gainsboro", "background-color" : "white"});
}


function afficherInfosTerrain(marker) {
	
	var gender; 
	switch(marker.anguille.sexe) {
    case 1:
    	gender = '<i class="fa fa-mars"></i>';
        break;
    case 2:
        gender = '<i class="fa fa-venus"></i>';
        break;
    default:
        gender = '<i class="fa fa-venus-mars"></i>';
	} 
	
	var nomLieu = (marker.anguille.nomLieu==undefined)?"":marker.anguille.nomLieu;
	var placeRestantes = (marker.anguille.nbMaxPart == undefined || marker.anguille.nbMaxPart == 0)?"Sans Limite de participant": marker.anguille.nbMaxPart - marker.anguille.nbParticipant + " Places restantes";
	var linkDetails = '';
	var nbPlaces = '';
	var diffPlaces = marker.anguille.nbMaxPart - marker.anguille.nbParticipant;
	var nbParticipants = '';
	var typeEvent = '';
	
	if ((marker.anguille.nbMaxPart - marker.anguille.nbParticipant < 10) && (marker.anguille.nbMaxPart != undefined) && (marker.anguille.nbMaxPart != 0)) {
		nbPlaces = ' | <span style="color: #ff6e5b"> <i class="fa fa-hourglass-half"></i> Il reste '+ diffPlaces + ' places !</span>';
	}
	
	if (marker.anguille.nbParticipant === 0) {
		nbParticipants = 'Pas encore de participant';
	}
	else {
		nbParticipants = marker.anguille.nbParticipant + ' participants';
	}
	
	if (marker.anguille.type == "Rencontre") {
		typeEvent = 'Rendez-vous';
		linkDetails = '<a href="detailRencontre.xhtml?idrencontre='+marker.anguille.id+'">Détails</a>';
	}
	else {
		typeEvent = 'Championnat';
		linkDetails = '<a href="detailsChampionnat.xhtml?idevenement='+marker.anguille.id+'">Détails</a>';
	}
	
	var divPres =
		'<div class="defautRencontre" id="'+ marker.anguille.id +'" style="padding:5px;margin:10px; margin-bottom: 20px;border : 1px solid gainsboro; border-radius: 10px; display: flex; flex-direction: row; justify-content: space-between;">'
			+ '<div class="date-recap" style="background-color: ' + marker.anguille.sportCouleur + '; display: flex; flex-direction: column; justify-content: space-between;padding: 10px 20px; margin-right: 30px; border-radius: 10px;">'
				+'<div style="display: flex; flex-direction: column;">'
					+'<span>'+ marker.anguille.dateJour+'</span>'
					+'<span>'+ marker.anguille.dateMois+'</span>'
				+'</div>'
				+'<img style="widht:30px; height:30px;" src="/SQUAD/'+ marker.anguille.sportIcone +'"/>'
			+'</div>'
			+ '<div style="flex-grow: 1;">'
				+ '<p style="color: #c3c2c2;">' 
					+ marker.anguille.dateDebut
				+'</p>'
				+'<h4>'+marker.anguille.libelle + '</h4>'
				+ '<img class="avatar" src="/SQUAD/'+ marker.anguille.orgaPhoto+'"/> '+marker.anguille.orga
				+ '<p><i class="fa fa-users"></i> ' + nbParticipants + '  ' + nbPlaces +'</p>'
				+ '<i class="fa fa-map-marker-alt"></i> '+ marker.anguille.adresse + ', ' + marker.anguille.codePostal + ' ' + marker.anguille.ville + '<br />'
			+ '</div>'
			+ '<div style="display: flex; flex-direction: column; justify-content: space-between; text-align: right; ">'
				
				+'<span style="background-color: gainsboro; color: white; font-weight: bold; padding: 5px; border-radius: 20px;">'+typeEvent+' </span>'	
				+'<span style=" font-size: 14px;">'+linkDetails+'</span>'
			+'</div>'
			+ '<div style="clear:both"></div>'
		+'</div>';

	$("#listeRencontres").append(divPres);


}



//VOir https://developers.google.com/places/web-service/details?hl=fr
//chopper les infos sur la ville;
function recupInfosVille(place) {  
	var infosVilleStruct = {
			locality: 'long_name',
			country: 'long_name',
			postal_code: 'long_name'
	};

	var infosVille = {};

	for (var i = 0; i < place.address_components.length; i++) {
		var addressType = place.address_components[i].types[0];
		if (infosVilleStruct[addressType]) {
			infosVille[addressType] = place.address_components[i][infosVilleStruct[addressType]];
		}
	}
	return infosVille;
}

