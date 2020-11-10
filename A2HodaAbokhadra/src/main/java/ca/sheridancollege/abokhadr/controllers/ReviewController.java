package ca.sheridancollege.abokhadr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ca.sheridancollege.abokhadr.beans.Review;
import ca.sheridancollege.abokhadr.database.DatabaseAccess;

@Controller
public class ReviewController {

	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String index(Model model) {

		da.insertReview();
		model.addAttribute("review", new Review());
		return "index";
	}

	@PostMapping("/insertReview")
	public String insertReview(Model model, @ModelAttribute Review review) {
		da.insertReview(review);
		model.addAttribute("review", new Review());
		model.addAttribute("reviewList", da.getReviewList());
		return "index";
	}
}
