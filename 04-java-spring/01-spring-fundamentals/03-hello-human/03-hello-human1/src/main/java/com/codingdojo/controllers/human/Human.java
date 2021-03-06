package com.codingdojo.controllers.human;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class Human {
	//one way
	@RequestMapping("/")
	public String index(Model model, @RequestParam(value="name", required=false, defaultValue="Human") String name) {
		model.addAttribute("name", name);
		return "index.jsp";
	}
	@RequestMapping("/{name}")
	public String showName(Model model, @PathVariable(value="name") String name) {
		model.addAttribute("modelName", name);
		return "index.jsp";
	}
	//using a separate page and a form
	/*@RequestMapping("/")
	public String index() {
		return "index2.jsp";
	}
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String showName(Model model, @RequestParam(value="name") String name) {
		model.addAttribute("modelName", name);
		return "result.jsp";
	}*/
}
