function getEvent(id) {
	if (document.getElementById("event" +   id).innerHTML == "") {
		//document.getElementById("event" + id).innerHTML = "hello!";

		fetch('http://localhost:8080/getEvent/' + id) // fetch data from our service
			.then(data => data.json()) // JSONify the data returned
			.then(function(data) { // with the JSON data
				// modify textToDisplay below here!

				var textToDisplay = ""; // create and append to a blank var
				textToDisplay += "ID: " + data.event.id + "<br>";
				textToDisplay += "Title: " + data.event.title + "<br>";
				textToDisplay += "Guests: " + data.event.guests + "<br>";
				textToDisplay += "Description: " + data.event.description + "<br>";
				textToDisplay += "Date: " + data.event.eventDate + "<br>";
				textToDisplay += "Time: " + data.event.eventTime + "<br>";

				// finally, change our relevant div to display the var
				document.getElementById("event" + id).innerHTML = textToDisplay;
			});

	} else {
		document.getElementById("student" + id).innerHTML = "";
	}
}

