package ca.sheridancollege.abokhadr.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ca.sheridancollege.abokhadr.beans.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc

public class TestStudentController {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void goodTestLoadingIndex() throws Exception {
		
		this.mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}
	
	@Test
	public void badTestLoadingIndex() throws Exception {
		
		this.mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
	}
	
	@Test
	public void goodtestLoadingInsertStudent() throws Exception {
	this.mockMvc.perform(post("/insertStudent").flashAttr("student", new Student()))
	.andExpect(status().isOk())
	.andExpect(view().name("index"));
	}
	
	@Test
	public void badTestLoadingInsertStudent() throws Exception {
	this.mockMvc.perform(post("/insertStudent").flashAttr("student", new Student()))
	.andExpect(status().isOk())
	.andExpect(view().name("index"));
	}
}
