package ca.sheridancollege.abokhadr.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ca.sheridancollege.abokhadr.beans.Course;

@Controller
public class CourseController {

	List<Course> courseList = new CopyOnWriteArrayList<Course>();

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("courseList", courseList);

		return "index";
	}

	@PostMapping("/addCourse")
	public String formPost(Model model,
			@RequestParam Long id,
			@RequestParam String prefix,
			@RequestParam String code,
			@RequestParam String name) {
		Course course = new Course(id, prefix, code, name);
		courseList.add(course);
		model.addAttribute("courseList", courseList);

		return "index";
	}
}