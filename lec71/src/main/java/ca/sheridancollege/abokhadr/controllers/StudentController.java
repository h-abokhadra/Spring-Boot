package ca.sheridancollege.abokhadr.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.abokhadr.beans.Student;

@Controller
public class StudentController {

	@GetMapping("/test")

	public String test(Model model, HttpSession session) {

		if (session.isNew())
			session.setAttribute("myTest", "New Session");
		else
			session.setAttribute("myTest", "Welcome Back");
		session.setAttribute("sessionID", session.getId());

		return "test";

	}

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("student", new Student());

		return "index";
	}

	@PostMapping("/insertStudent")
	public String insertStudent(HttpSession session, Model model, @ModelAttribute Student student) {

		List<Student> studentList;

		if (session.isNew())
			studentList = new CopyOnWriteArrayList<Student>();

		else
			studentList = (CopyOnWriteArrayList<Student>) session.getAttribute("studentList");
		studentList.add(student);
		session.setAttribute("studentList", studentList);

		model.addAttribute("student", new Student());
		return "index";
	}

}
