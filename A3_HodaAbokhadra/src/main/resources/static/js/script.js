function verify() {
	var password1 = document.forms['form']['password'].value;
	var password2 = document.forms['form']['verifyPassword'].value;
	if (password1 == null || password1 == "" || password1 != password2) {
		document.getElementById("error").innerHTML = "Please check your passwords";
		return false;
	}
}

///// main entry point = DOMContentLoaded
$(document).ready(function() {
	//
	let anchors = $(".menu > a");
	//console.log(anchors.length);


	// bind click events on all anchors
	anchors.click(function() {
		// get target ID from the "href" attribute of <a>
		let target = $(this).attr("href");
		// compute top offset
		let offsetTop = $(target).offset().top - $(".menu").height();
		// start page scrolling animation
		$("html, body").animate({ scrollTop: offsetTop }, 500);
	});

});
