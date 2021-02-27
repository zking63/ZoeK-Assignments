package com.codingdojo.controllers.dojosurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/result")
	public String result(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		return "result.jsp";
	}
}
