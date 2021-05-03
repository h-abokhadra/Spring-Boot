package ca.sheridancollege.abokhadr.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.abokhadr.beans.Event;
import ca.sheridancollege.abokhadr.database.DatabaseAccess;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class EventController {

	private DatabaseAccess da;

	@GetMapping
	public List<Event> getEventCollection() {
		return da.findAll();
	}

	@GetMapping(value = "/{id}") // value only here to illustrate our Mappings can do more!
	public Event getIndividualEvent(@PathVariable Long id) {
		return da.findById(id);
	}

	@PostMapping(consumes = "application/json")
	public Long postEvent(@RequestBody Event event) {
		return da.save(event);
	}

	@PutMapping(consumes = "application/json")
	public String putEventCollection(@RequestBody List<Event> eventList) {
		da.deleteAll();
		da.saveAll(eventList);
		return "Total Records: " + da.count();
	}
	
	@PutMapping(value = "/{id}",consumes = "application/json")
	public Long putEvent(@RequestBody Event event, @PathVariable Long id) {
		da.deleteById(id);
		event.setId(id);
		return da.saveById(event);
	}
	
	@DeleteMapping (value = "/{id}")
	public String deleteEvent(@PathVariable Long id) {
		 da.deleteById(id);
		return " Item " + id + " deleted. ";
	}
	
	@DeleteMapping ()
	public String deleteEventCollection() {
		 da.deleteAll();
		return " Collection  deleted. ";
	}
	


	
	
}
