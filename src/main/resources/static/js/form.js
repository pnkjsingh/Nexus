	hue.oninput = e =>
	document.firstElementChild.style.setProperty('--hue', e.target.value);

	// Get the modal element
	var modal = document.getElementById("createcaseform");
	
	// Get the close button element
	var closeButton = document.querySelector(".close");

	// Function to open the modal and set the message
	function openModal(message, reloadForm) {
		modal.style.display = "block";
		var messageContainer = modal.querySelector("p");
		messageContainer.textContent = message;
		if (reloadForm) {
			// Reload the form after closing the modal
			closeButton.onclick = function () {
				modal.style.display = "none";
				location.reload(); // Reload the page to reset the form
			};
		} else {
			// Close the modal without reloading the form
			closeButton.onclick = closeModal;
		}
	}

	// Function to close the modal
	function closeModal() {
		modal.style.display = "none";
		window.location.href = '/admin';
	}

	// Close the modal when the user clicks outside of it
	window.onclick = function (event) {
		if (event.target == modal) {
			closeModal();
			window.location.href = '/insuranceclaim/show';
		}
	};

	// Function to handle form submission
	function submitForm() {
		var formData = new FormData(document.getElementById("createcaseform"));
		
		// Use AJAX to submit the form data
		// Replace '/your-api-endpoint' with the actual endpoint where you handle form submission on the server
		// You can use libraries like jQuery or fetch for the AJAX request
		fetch('/insuranceclaim/add', {
			method: 'POST',
			body: formData
		})
		.then(response => response.json())
		.then(data => {
			if (data.success) {
				// If the submission was successful, display a success message
				openModal("Insurance Claim added successfully!", true); // Reload the form after closing
				// Optionally, you can reset the form here
				document.getElementById('submit').addEventListener('submit', fu);
				document.getElementById("createcaseform").reset();
			} else {
				// If the submission was unsuccessful, display an error message
				openModal("Error adding Insurance-Claim", false); // Don't reload the form
			}
		})
		.catch(error => {
			console.error('Error:', error);
			openModal("An error occurred while processing your request.", false); // Don't reload the form
		});
	}

/*	document.addEventListener('DOMContentLoaded', function () {
		// Get references to the form and submit button
		const form = document.getElementById('createcaseform');
		const submitButton = document.getElementById('submit');
		
		// Add a submit event listener to the form
		form.addEventListener('submit', function (event) {
			// Prevent the default form submission
			
			event.preventDefault();
						
			// Disable the submit button to prevent multiple submissions
			
			submitButton.disabled = true;
			
			// You can optionally display a message to indicate that the form is being processed
			// For example, you can display a "Please wait..." message.
			
			// Then, you can submit the form programmatically (if needed)
			// form.submit();
		});
	});
*/