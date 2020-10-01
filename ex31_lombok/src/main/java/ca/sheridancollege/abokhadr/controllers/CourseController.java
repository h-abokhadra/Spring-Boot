package ca.sheridancollege.abokhadr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.abokhadr.beans.Course;
import ca.sheridancollege.abokhadr.repositories.CourseListImpl;

@Controller
public class CourseController {

	private CourseListImpl courseList;

	public CourseController(CourseListImpl courseList) {
		super();
		this.courseList = courseList;
	}

	@GetMapping("/")
	public String index(Model model) {

		System.out.println("Clearing List");
		courseList.emptyList();
		return "index";
	}

	@PostMapping("/formPost")
	public String formPost(@RequestParam Long id, @RequestParam String prefix,
			@RequestParam int code, @RequestParam String name) {

		Course course = Course.builder()
				.id(Long.valueOf(id))
				.prefix(prefix)
				.code(code)
				.name(name)
				.build();
		

		courseList.getCourseList().add(course);

		System.out.println("****");

		for (Course c : courseList.getCourseList()) {

			System.out.println(c);
		}

		return "bingooo";
	}
}