package ca.sheridancollege.abokhadr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.abokhadr.beans.Contact;
import ca.sheridancollege.abokhadr.database.DatabaseAccess;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ContactController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("contactList", da.getContactList());
		return "index";
	}
	
	@PostMapping("insertContact")
	public String insertStudent(Model model, @ModelAttribute Contact contact) {
		da.insertContact(contact);
		model.addAttribute("contact", new Contact());
		model.addAttribute("contactList", da.getContactList());
		return "index";
	}
	
	

	@GetMapping("/deleteContactById/{id}")
	public String deleteContactById(Model model, @PathVariable Long id) {
		da.deleteContactById(id);
		model.addAttribute("contact", new Contact());
		model.addAttribute("contactList", da.getContactList());
		return "index";
	}

	@GetMapping("/editContactById/{id}")
	public String editContactById(Model model, @PathVariable Long id) {

		Contact contact = da.getContactListById(id).get(0);
		model.addAttribute("contact", contact);
		da.deleteContactById(id);
		model.addAttribute("contactList", da.getContactList());

		return "index";
	}
	
}
