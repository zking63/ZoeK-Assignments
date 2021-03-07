package com.codingdojo.driverslicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.driverslicense.models.License;
import com.codingdojo.driverslicense.models.Person;
import com.codingdojo.driverslicense.services.DriversService;

@Controller
public class DLController {
	private final DriversService dservice;
	public DLController(DriversService dservice) {
		this.dservice = dservice;
	}
	@RequestMapping("/persons")
	public String index(Model model) {
		model.addAttribute("persons", dservice.getPeople());
		return "/persons/index.jsp";
	}
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person")Person person) {
		return "/persons/newperson.jsp";
	}
	@RequestMapping(value="/persons", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "persons/newperson.jsp";
		}
		else {
			dservice.createPerson(person);
			return "redirect:/persons";
		}
	}
	@RequestMapping("/license/new")
	public String newLicense(@ModelAttribute("license")License license, Model model) {
		List<Person> unlicensed = dservice.getUnlicensedPeople();
		model.addAttribute("persons", unlicensed);
		return "/license/newlicense.jsp";
	}
	@RequestMapping(value="/license", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "license/newlicense.jsp";
		}
		else {
			dservice.createLicense(license);
			return "redirect:/persons";
		}
	}
	@RequestMapping("/persons/{id}")
	public String ShowPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", dservice.getPerson(id));
		return "/persons/show.jsp";
	}
}
