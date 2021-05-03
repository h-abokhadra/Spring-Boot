package ca.sheridancollege.abokhadr.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.abokhadr.beans.Event;
import ca.sheridancollege.abokhadr.database.DatabaseAccess;

@Controller
public class HomeController {

	@Autowired
	private DatabaseAccess da;

	@GetMapping("/viewEvents")
	public String viewEvents(Model model, RestTemplate restTemplate) {
		model.addAttribute("event", new Event());
		ResponseEntity<Event[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/events",
				Event[].class);
		model.addAttribute("eventList", responseEntity.getBody());
		return "/viewEvents";
	}
	
	@PostMapping("/insertEvent")
	public String insertEvent(Model model, @ModelAttribute Event event) {
	    System.out.println("print");
		da.save(event);
		model.addAttribute("eventList", da.findAll());
		return "/viewEvents";
	}

	@GetMapping(value = "/getEvent/{id}", produces = "application/json")
	@ResponseBody
	public Map<String, Object> getEvent(@PathVariable int id, RestTemplate restTemplate) {
		Map<String, Object> data = new HashMap<String, Object>();
		ResponseEntity<Event> responseEntity = restTemplate.getForEntity("http://localhost:8080/events/" + id,
				Event.class);
		data.put("event", responseEntity.getBody());
		return data;
	}

}
