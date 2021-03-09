package com.codingdojo.studentrosteri.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.studentrosteri.models.Dojo;
import com.codingdojo.studentrosteri.models.Ninja;
import com.codingdojo.studentrosteri.services.RosterServices;

@Controller
public class RosterController {
	private final RosterServices rservice;
	public RosterController (RosterServices rservice) {
		this.rservice = rservice;
	}
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("dojo", rservice.listDojos());
		model.addAttribute("ninja", rservice.listNinjas());
		return "index.jsp";
	}
	@RequestMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "/dojo/newdojo.jsp";
	}
	@RequestMapping(value="/dojo", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo/newdojo.jsp";
		}
		else {
			rservice.createDojo(dojo);
			return "redirect:/";
		}
	}
	@RequestMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> dojos = rservice.listDojos();
		model.addAttribute("dojo", dojos);
		return "/ninja/newninja.jsp";
	}
	@RequestMapping(value="/ninja", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "ninja/newninja.jsp";
		}
		else {
			rservice.createNinja(ninja);
			return "redirect:/";
		}
	}
	@RequestMapping("/dojo/{id}")
	public String ShowDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", rservice.findDojo(id));
		return "/dojo/show.jsp";
	}
	 @RequestMapping(value="/ninja/delete/{id}")
	 public String deleteNinja(@PathVariable("id") Long id) {
	     rservice.deleteNinja(id);
	     return "redirect:/";
	 }
}
