//c'est cadeau bande de salopes
//« before you can be great, you’ve got to be good. 
//	Before you can be good, you’ve got to be bad. 
//	But before you can even be bad, you’ve got to try.” – Art Williams

var map;
var infowindow;
var markers = [];
var sportSelected = "";

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


	var input = document.getElementById('pac-input');

	var searchBox = new google.maps.places.Autocomplete(input,options);
	map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

	map.addListener('bounds_changed', function() {
		searchBox.setBounds(map.getBounds());
		
		
	//map.refresh();
	
	});



	//DEBUT EVENT Recherche sur une nouvelle ville ****
	searchBox.addListener('place_changed', function() {

		var place = searchBox.getPlace();

		markers.forEach(function(marker) {
			marker.setMap(null);
		});

		//clear marker + div infos
		markers = [];
		$("#resultatRechercheTerrains").html("");

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

		var infosVille = recupInfosVille(place);

		var listeTerrains = recupererTerrains(infosVille);

		listeTerrains(function (data) {
			var listeTerrains = data.records;

			for(i=0; i < listeTerrains.length; i++ ) {
				afficherMarker(listeTerrains[i]);
			}
		});

	});
	//FIN ****Recherche sur une nouvelle ville ****
}


//retourne methode success @liste des terrains (IDF) pour une ville donnée
function recupererTerrains(infosVille) {

	var defaultParams = {"dataset":"20170419_res_fichesequipementsactivites","rows":"100"};

	defaultParams["refine.inscodepostal"] = infosVille.postal_code;
	defaultParams["refine.comlib"] = infosVille.locality;
	defaultParams["q"] = sportSelected;

	var req = $.ajax({
		type:"GET",
		contentType:"application/x-www-form-urlencoded",
		url:"https://data.iledefrance.fr/api/records/1.0/search/",
		async:true,
		data:defaultParams
	});

	return req.success;
}

function afficherMarker(terrain) {

	var point = {lat:terrain.fields.equgpsy,lng:terrain.fields.equgpsx};

	var marker = new google.maps.Marker({
		position: point,
		animation: google.maps.Animation.DROP,
		map: map,
	});
	
	 marker.setIcon('http://maps.google.com/mapfiles/ms/icons/red-dot.png');
	//trick de fouine pour ajouter des infos perso (infos du terrain) sur l'objet marker dynamiquement
	//putain js c'est génial, mais c'est vraiment n'importe quoi X|
	//j'aime tout.
	marker.anguille = terrain.fields;

	afficherInfosTerrain(marker);

    google.maps.event.addListener(marker, 'click', function() {
      for(i=0;i<markers.length;i++) {
        markers[i].setIcon('http://maps.google.com/mapfiles/ms/icons/red-dot.png');
      }
      marker.setIcon('http://maps.google.com/mapfiles/ms/icons/blue-dot.png');
      infowindow.setContent(terrain.fields.insnom);
      infowindow.open(map, this);
      
      clearMarkerStyle();
      
      $("#"+marker.anguille.equipementid).css({"border" : "3px solid #62d7a1"});
      
      //ajouter infos aux champs cachés:
      ajouterInfosChampsCaches(marker);
      
    });
    
    $("#"+marker.anguille.equipementid).click(function() {
    	google.maps.event.trigger(marker,'click');
    })

	markers.push(marker);
}

function clearMarkerStyle() {
	$('.defautTerrain').css({"border":"1px solid gainsboro"});
}

function ajouterInfosChampsCaches(marker) {
	
	$("#formCreationRencontre\\:inputNomLieu").val(marker.anguille.insnom);
	$("#formCreationRencontre\\:inputAdresse").val(marker.anguille.inslibellevoie);
	$("#formCreationRencontre\\:inputAdresseLat").val(marker.anguille.equgpsy);
	$("#formCreationRencontre\\:inputAdresseLong").val(marker.anguille.equgpsx);
	$("#formCreationRencontre\\:inputCodePostal").val(marker.anguille.inscodepostal);
	$("#formCreationRencontre\\:inputVille").val(marker.anguille.comlib);
	
	console.log("ajout infos aux champs cachés!");
}

function afficherInfosTerrain(marker) {
	
    var divPres = '<div class="defautTerrain" id="'+marker.anguille.equipementid +'" style="padding:5px;margin:5px;border: 1px solid gainsboro;">'
    		  + '<img style="margin: 10px;margin-bottom:60px;width:40px;height:40px;float:left;" src="https://image.flaticon.com/icons/svg/33/33622.svg" />'
              + '<b>'+marker.anguille.insnom + '</b><br />'
              + '<small>' + marker.anguille.equnom + '<i>('+ marker.anguille.naturesollib +')</i><br />'
              + marker.anguille.actlib + '<br />'
              + marker.anguille.inslibellevoie + '<br />'
              + marker.anguille.inscodepostal + '  ' + marker.anguille.comlib + '</small><div style="clear:both"></div></div>';

    $("#resultatRechercheTerrains").append(divPres);
    
    
    // var presTop = '<img style="margin: 10px;width:40px;height:40px;float:left;" src="http://maps.google.com/mapfiles/ms/icons/blue-dot.png" />'
    //           + '<b>'+marker.anguille.insnom + '</b><br />'
    //           + marker.anguille.inslibellevoie + '<br />'
    //           + marker.anguille.inscodepostal + '  ' + marker.anguille.comlib + '<br />';

    // $("#divDetails").html(presTop);

    // var presBot = '<table>'
    //     + '<tr><td>Gestionnaire: </td><td>' + marker.anguille.gestiontypegestionnaireprinclib + '</td></tr>'
    //     + '<tr><td>Activite</td><td>' + marker.anguille.actlib + '</td></tr>'
    //     + '<tr><td>Acces Handic: </td><td>' + marker.anguille.equacceshandimaire + '</td></tr>'
    //     + '<tr><td>Places parking: </td><td>' + marker.anguille.insnbplaceparking + '</td></tr>'
    //     + '<tr><td>Nature: </td><td>' + marker.anguille.naturelibelle + '</td></tr>'
    //     + '<tr><td>Surface: </td><td>' + marker.anguille.naturesollib + '</td></tr>'
    //     + '<tr><td>Vestiaire: </td><td>' + marker.anguille.equaccueillocalrangement + '</td></tr>'
    //     + '</table>';

    // $("#tableCaca").html(presBot);
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

