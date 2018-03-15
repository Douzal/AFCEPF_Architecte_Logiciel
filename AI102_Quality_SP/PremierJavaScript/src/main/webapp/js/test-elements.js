// wait for DOM 
window.onload = function() {
	document.monForm.onsubmit = foo;
};
function foo() {
	let nombre = Number(document.monForm.nb.value);
	for (let i = 1; i <= nombre; i++) {
		let unBtn = document.createElement("input");
		unBtn.setAttribute("type", "button");
		unBtn.setAttribute("value", i);
		with (unBtn.style) {
			backgroundColor = "pink";
			width = "50px";
			height = "50px";
		}
		unBtn.onclick = function() {
			this.remove();
		};
		unBtn.onmouseover = function() {
			with (this.style) {
				position = "absolute";
				left = (Math.random() * 500) + "px";
				top = (Math.random() * 500) + "px";
			}
		};
		unBtn.onfocus = function() {
			document.monForm.nb.focus();
		}
		document.getElementById("boutons")
				.appendChild(unBtn);
	}
	return false;
}