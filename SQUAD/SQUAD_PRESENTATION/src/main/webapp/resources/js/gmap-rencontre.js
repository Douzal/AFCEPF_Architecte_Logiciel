var markers=[];
var map;
var rencontres;

function initAutocomplete() {
	map = new google.maps.Map(document.getElementById('map'), {
		center: {lat: 48.862000, lng: 2.333669},
		zoom: 11,
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

	// Create the search box and link it to the UI element.
	var input = document.getElementById('pac-input');
	var searchBox = new google.maps.places.Autocomplete(input,options);
	map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
	
	rencontres = document.getElementById('formMap\:rencontres').getAttribute('value').split("/");
	
	for(i=0; i < rencontres.length; i++ ) {
		afficherMarker(rencontres[i]);
	}
	
	// Bias the SearchBox results towards current map's viewport.
	map.addListener('bounds_changed', function() {
		searchBox.setBounds(map.getBounds());
	});

	searchBox.addListener('place_changed', function() {
		console.log("event searchBox");
		var place = searchBox.getPlace();
		
		markers.forEach(function(marker) {
			marker.setMap(null);
		});
		
		markers = [];
		
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

		recupInfosVille(place);
		
		for(i=0; i < rencontres.length; i++ ) {
			afficherMarker(rencontres[i]);
		}
	});
}

// 1) Prendre les infos renvoyées par Google Map
// 2) Mettre le String ville dans l'inputHidden
// 3) Déclencher la méthode de recherche de participations du mbMembre

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
	
	var filtreVille = infosVille.locality;
	
	document.getElementById('formMap\:ville').setAttribute('value', filtreVille);
	document.getElementById('formMap\:filtrer').click();
	
	rencontres = document.getElementById('formMap\:rencontres').getAttribute('value').split("/");
	
	console.log(document.getElementById('formMap\:rencontres').getAttribute('value'));
	console.log("rencontres : "+ rencontres);
}

function afficherMarker(rencontre) {
	console.log("rencontre: " + rencontre);
	console.log("LATITUDE : " + JSON.parse(rencontre).lat);
	console.log("LONGITUDE : " + JSON.parse(rencontre).lng);
	
	var point = {lat: JSON.parse(rencontre).lat, lng: JSON.parse(rencontre).lng};
	
	var marker = new google.maps.Marker({
		position: point,
		animation: google.maps.Animation.DROP,
		map: map,
	});
	
	marker.setIcon('http://maps.google.com/mapfiles/ms/icons/red-dot.png');
	
	markers.push(marker);
}