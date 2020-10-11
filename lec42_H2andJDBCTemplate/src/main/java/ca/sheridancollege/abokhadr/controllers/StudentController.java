package ca.sheridancollege.abokhadr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ca.sheridancollege.abokhadr.beans.Student;
import ca.sheridancollege.abokhadr.database.DatabaseAccess;

@Controller
public class StudentController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index(Model model) {
		
		da.insertStudent();
		
		model.addAttribute("student", new Student());
		return "index";
	}
}
