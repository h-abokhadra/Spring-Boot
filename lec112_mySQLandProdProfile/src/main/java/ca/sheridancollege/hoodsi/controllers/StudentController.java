package ca.sheridancollege.hoodsi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.hoodsi.beans.Student;
import ca.sheridancollege.hoodsi.database.DatabaseAccess;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudentController {

	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudentList());
		return "index";
	}
	
	@PostMapping("insertStudent")
	public String insertStudent(Model model, @ModelAttribute Student student) {
		da.insertStudent(student);
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudentList());
		return "index";
	}
	
}
