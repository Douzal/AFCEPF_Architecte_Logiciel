function getXmlHttpRequest() {
	let http_request = false;
	if (window.XMLHttpRequest) { // tous les navs ... sauf IE
		http_request = new XMLHttpRequest();
		// what did you expect?
//		http_request.overrideMimeType("text/xml");
		http_request.overrideMimeType("text/html");
	} else if(window.ActiveXObject) {
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP"); // <= IE 5
		} catch (e) {
			http_request = new ActiveXObject("Microsoft.XMLHTTP"); // >= IE 6
		}
	}
	return http_request;
}
// definition des evenements
window.onload = function() {
	// traitement sale pour la premiere page
	try {
		document.formAjax.onsubmit = callPremierAjax;
		document.formAjax.saisie.onkeyup = callPremierAjax;
	} catch (e) {
		console.log(e);
	}
	// traitement sale pour la deuxieme page
	try {
		document.forms["form-recherche-ajax"].onsubmit = callRechercheAjax;
		document.forms["form-recherche-ajax"].nom.onkeyup = callRechercheAjax;
	} catch (e) {
		console.log(e);
	}
}
function callPremierAjax() {
	let http_request = getXmlHttpRequest();
	let parameters = "pascal=" + encodeURI(document.formAjax.saisie.value);
	http_request.open("POST", "premier-ajax.aspx", true);
	http_request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	http_request.onreadystatechange = function() {
		callbackAjax(http_request, document.getElementById("raiponce"));
	};
	http_request.send(parameters);
	return false;
}
function callRechercheAjax() {
	let http_request = getXmlHttpRequest();
	let parameters = "nom=" + encodeURI(document.forms["form-recherche-ajax"].nom.value);
	http_request.open("POST", "recherche-ajax.aspx", true);
	http_request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	http_request.onreadystatechange = function() {
		callbackAjax(http_request, document.getElementById("resultat-recherche"));
	};
	http_request.send(parameters);
	return false;
}
// un callback permet de realiser un traitement de maniere asynchrone
// apres la fin du traitement de la methode le definissant.
function callbackAjax(http_request, noeud) {
	if (http_request.readyState == 4) {
		if (http_request.status == 200) {
			noeud.innerHTML = http_request.responseText;
		} else {
			alert("pb serveur");
		}
	}
}