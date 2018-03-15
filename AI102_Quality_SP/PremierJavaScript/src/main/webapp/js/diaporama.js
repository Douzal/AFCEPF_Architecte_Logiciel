window.onload = function() {
	let imagesList = document.getElementById("images").getElementsByTagName("img");
	for(let i = 0 ; i < imagesList.length ; i++) {
		with(imagesList[i].style) {
			width = "100px";
			height = "100px";
		};
		imagesList[i].onmouseover = function() {
			document.getElementById("grande-image").src = this.src;
		}
	}
	let grande = document.createElement("img");
	grande.id = "grande-image";
	with(grande.style) {
		width = (imagesList.length * 100) + "px";
		height = (imagesList.length * 100) + "px";
		display = "block";
	};
	grande.src = imagesList[0].src;
	document.getElementById("images").appendChild(grande);
	test();
}
var cpt = 0;
var liste;
function test() {
	liste = document.getElementById("images").getElementsByTagName("img");
	demarrer();
}
function demarrer() {
	setInterval("suivante()", 1000);
}
function suivante() {
	source = liste[cpt++].src;
	if(cpt == liste.length - 1) cpt = 0;
	document.getElementById("grande-image").src = source;
}