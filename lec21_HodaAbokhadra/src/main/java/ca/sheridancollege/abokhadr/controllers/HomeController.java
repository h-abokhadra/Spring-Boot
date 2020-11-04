package ca.sheridancollege.abokhadr.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.abokhadr.beans.Student;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {

		return "index";
	}

	@PostMapping("/formPost")
	public String formPost(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam Long studentNumber, @RequestParam LocalDate birthday) {

		Student student = new Student();

		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setStudentNumber(studentNumber);
		student.setBirthday(birthday);

		System.out.println(student);

		return "working";
	}

}
