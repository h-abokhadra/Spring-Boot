package ca.sheridancollege.abokhadr.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.abokhadr.beans.VideoGame;

@Controller
public class VideoGameController {
	
	List<VideoGame> videoGameList = new CopyOnWriteArrayList<VideoGame>();

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("videoGame", new VideoGame());
		model.addAttribute("videoGameList", videoGameList);
		return "index";
	}
	
	@PostMapping("/addVideoGame")
	public String addVideoGame(Model model, @ModelAttribute VideoGame videoGame) {
		videoGameList.add(videoGame);
		model.addAttribute("videoGame", new VideoGame());
		model.addAttribute("videoGameList", videoGameList);
		return "index";
	}
}
