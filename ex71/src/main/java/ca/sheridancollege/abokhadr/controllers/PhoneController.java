
package ca.sheridancollege.abokhadr.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ca.sheridancollege.abokhadr.beans.Phone;

@Controller
public class PhoneController {

	@GetMapping("/index")

	public String test(Model model, HttpSession session) {

		if (session.isNew())
			session.setAttribute("myPhone", "New Session");
		else
			session.setAttribute("myPhone", "Welcome Back");
		session.setAttribute("sessionID", session.getId());

		return "index";

	}

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("phone", new Phone());

		return "index";
	}

	@PostMapping("/insertPhone")
	public String insertPhone(HttpSession session, Model model, @ModelAttribute Phone phone) {

		List<Phone> phoneList;

		if (session.isNew())
			phoneList = new CopyOnWriteArrayList<Phone>();
		else
			phoneList = (CopyOnWriteArrayList<Phone>) session.getAttribute("phoneList");
		phoneList.add(phone);
		session.setAttribute("phoneList", phoneList);

		model.addAttribute("phone", new Phone());
		return "index";
	}

}
