package ca.sheridancollege.abokhadr.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.abokhadr.beans.Student;
import ca.sheridancollege.abokhadr.database.DatabaseAccess;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

	private DatabaseAccess da;

	@GetMapping
	public List<Student> getStudentCollection() {
		return da.findAll();
	}

	@GetMapping(value = "/{id}") // value only here to illustrate our Mappings can do more!
	public Student getIndividualStudent(@PathVariable Long id) {
		return da.findById(id);
	}

	@PostMapping(consumes = "application/json")
	public Long postStudent(@RequestBody Student student) {
		return da.save(student);
	}

	@PutMapping(consumes = "application/json")
	public String putStudentCollection(@RequestBody List<Student> studentList) {
		da.deleteAll();
		da.saveAll(studentList);
		return "Total Records: " + da.count();
	}
	
	
}
