$(autoheight);
$(window).resize(autoheight);
function autoheight() {
	if ($(window).height() > 800) {
		$(".main").css("height", "800px");
	} else if ($(".main").css("height") < "450px") {
		$(".main").css("height", "480px");
	}
}
