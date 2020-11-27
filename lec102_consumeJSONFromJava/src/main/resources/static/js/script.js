function getStudent(id) {
	if (document.getElementById("student" +   id).innerHTML == "") {
		//document.getElementById("student" + id).innerHTML = "hello!";

		fetch('http://localhost:8080/getStudent/' + id) // fetch data from our service
			.then(data => data.json()) // JSONify the data returned
			.then(function(data) { // with the JSON data
				// modify textToDisplay below here!

				var textToDisplay = ""; // create and append to a blank var
				textToDisplay += "ID: " + data.student.id + "<br>";
				textToDisplay += "Name: " + data.student.name + "<br>";
				textToDisplay += "Grade: " + data.student.grade + "<br>";
				textToDisplay += "Letter Grade: " + data.student.letterGrade + "<br>";
				textToDisplay += "Attended: " + data.student.attended + "<br>";
				textToDisplay += "Participated: " + data.student.participated + "<br>";

				// finally, change our relevant div to display the var
				document.getElementById("student" + id).innerHTML = textToDisplay;
			});

	} else {
		document.getElementById("student" + id).innerHTML = "";
	}
}

