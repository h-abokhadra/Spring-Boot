package ca.sheridancollege.abokhadr.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.abokhadr.beans.Appointment;
import ca.sheridancollege.abokhadr.database.DatabaseAccess;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {

	@Autowired
	@Lazy
	private DatabaseAccess da;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/secure/viewAppointments")
	
	public String viewAppointments(Model model,  @ModelAttribute Appointment appointment){
		model.addAttribute("appointment", appointment);
		model.addAttribute("appointmentList", da.getAppointmentList());

		return "/secure/viewAppointments";
	}
	

	@PostMapping("/insertAppointment")
	public String insertAppointment(Model model, @ModelAttribute Appointment appointment) {
		System.out.println("print");
		da.insertAppointment(appointment);
		model.addAttribute("appointment", new Appointment());
		model.addAttribute("appointmentList", da.getAppointmentList());
		return "/secure/viewAppointments";
	}

	@GetMapping("/deleteAppointmentById/{id}")
	public String deleteAppointmentById(Model model, @PathVariable Long id) {
		da.deleteAppointmentById(id);
		model.addAttribute("appointment", new Appointment());
		model.addAttribute("appointmentList", da.getAppointmentList());
		return "/secure/viewAppointments";
	}

	@GetMapping("/editAppointmentById/{id}")
	public String editAppointmentById(Model model, @PathVariable Long id) {

		Appointment appointment = da.getAppointmentListById(id).get(0);
		model.addAttribute("appointment", appointment);
		da.deleteAppointmentById(id);
		model.addAttribute("appointmentList", da.getAppointmentList());

		return "/secure/viewAppointments";
	}

	@GetMapping("/secure")
	public String secureIndex(Authentication authentication, Model model) {

		String email = authentication.getName();
		List<String> roleList = new ArrayList<String>();
		for (GrantedAuthority ga : authentication.getAuthorities()) {
			roleList.add(ga.getAuthority());
		}
		
		model.addAttribute("email", email);
		model.addAttribute("roleList", roleList);
		model.addAttribute("appointmentList", da.getAppointmentList());
		return "/secure/index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/permission-denied")
	public String permissionDenied() {
		return "/error/permission-denied";
	}

	@GetMapping("/register")
	public String getRegister() {
		return "register";
	}

	@PostMapping("/register")
	public String postRegister(@RequestParam String username, @RequestParam String password) {
		// more code here in a jiff
		da.addUser(username, password);
		Long userId = da.findUserAccount(username).getUserId();
		da.addRole(userId, Long.valueOf(2));
		return "redirect:/";
	}
}
