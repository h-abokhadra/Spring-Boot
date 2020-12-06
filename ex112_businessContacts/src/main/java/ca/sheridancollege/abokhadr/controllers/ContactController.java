package ca.sheridancollege.abokhadr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.abokhadr.beans.Contact;
import ca.sheridancollege.abokhadr.database.DatabaseAccess;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ContactController {

	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("student", new Contact());
		model.addAttribute("studentList", da.getStudentList());
		return "index";
	}
	
	@PostMapping("insertStudent")
	public String insertStudent(Model model, @ModelAttribute Contact student) {
		da.insertStudent(student);
		model.addAttribute("student", new Contact());
		model.addAttribute("studentList", da.getStudentList());
		return "index";
	}
	
}
