var map;

function initAutocomplete() {
	var infosRencontre = JSON.parse(document.getElementById("formMap\:infosRencontre").getAttribute('value'));
	console.log(infosRencontre);
	
	var point = {lat: infosRencontre.lat, lng: infosRencontre.lng};
	
	map = new google.maps.Map(document.getElementById('map'), {
		center: point,
		zoom: 16,
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
	
	var marker = new google.maps.Marker({
		position: point,
		animation: google.maps.Animation.DROP,
		map: map,
	});

	var options = {
			types: ['(regions)'],
			componentRestrictions: {country: "fr"}
	};
}
