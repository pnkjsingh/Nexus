	hue.oninput = e =>
	document.firstElementChild.style.setProperty('--hue', e.target.value);

		/* Home Pade 3rd Slide */
 		document.addEventListener("DOMContentLoaded", function () {
			const menuLinks = document.querySelectorAll(".menu a");
			const contentSections = document.querySelectorAll(".main-content section");

			// Initialize by displaying the first content section
			contentSections[0].style.display = "block";

			menuLinks.forEach(function (link) {
				link.addEventListener("click", function (event) {
					event.preventDefault();
					const contentId = link.getAttribute("data-content");

					// Hide all content sections
					contentSections.forEach(function (section) {
						section.style.display = "none";
					});

					// Show the selected content section
					document.getElementById(contentId).style.display = "block";
				});
			});
		});


 	let slideIndex = 0;

	function showSlides() {
	    const slides = document.getElementsByClassName("mySlides");
	    for (let i = 0; i < slides.length; i++) {
	        slides[i].style.display = "none";
	    }

	    slideIndex++;

	    if (slideIndex > slides.length) {
	        slideIndex = 1;
	    }

	    slides[slideIndex - 1].style.display = "block";
	    setTimeout(showSlides, 5000); // Change image every 2 seconds
	}

	// Function to manually navigate to the previous or next slide
	function plusSlides(n) {
		slideIndex += n;
		const slides = document.getElementsByClassName("mySlides");

		if (slideIndex < 1) {
			slideIndex = slides.length;
		} else if (slideIndex > slides.length) {
			slideIndex = 1;
		}

		for (let i = 0; i < slides.length; i++) {
			slides[i].style.display = "none";
		}

		slides[slideIndex - 1].style.display = "block";
	}

	// Start the slideshow
	showSlides();

// Check if the current page is the Home page (Home.html)
/*if (window.location.pathname.endsWith("/Home.html")) {

}*/