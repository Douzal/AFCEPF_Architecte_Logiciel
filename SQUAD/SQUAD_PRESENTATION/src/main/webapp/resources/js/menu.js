$(function() {
    var estOffCanvas = false;

        $("#icone-burger").on("click",function() {
            if (!this.estOffCanvas) {
                openNav();
                this.estOffCanvas = true;
            }
            else {
                closeNav();
                this.estOffCanvas = false;
            }
        });


    $( window ).on("resize", function() {
        if ($(window).width()>=750) {
            closeNav();
            this.estOffCanvas = false;
        }
    });
    
    $("#avatar-compte-nav").on("click",function() {
    	document.getElementById("dropdown-compte").classList.toggle("montrer");
    });
    
    $(window).on("click", function(event) {
    	if (!event.target.matches('#dropdown-compte')) {
    		
    	}
    });
    
});

function openNav() {
    $("#sidenav").css({"width" : "250px"});
    $("#main").css({"margin-left" : "250px"});
    $("#icone-burger").css({"left" : "250px"});
    $(".nav-logo").css({"display": "none"});
}

function closeNav() {
    $("#sidenav").css({"width" : "0"});
    $("#main").css({"margin-left" : "0"});
    $("#icone-burger").css({"left" : "0"});
    $(".nav-logo").css({"display": "block"});
}
