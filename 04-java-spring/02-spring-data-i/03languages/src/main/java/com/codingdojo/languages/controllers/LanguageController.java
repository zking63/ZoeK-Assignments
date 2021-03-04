package com.codingdojo.languages.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {
	private LanguageService languageService;
	public LanguageController(LanguageService service){
	    this.languageService = service;
	}
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("Languages", languageService.allLanguages());
		return "index.jsp";
	}
	//instantiating a new language type and binding to our view model
	//binding to our model will allow us to create a form that is also bound to the language type, which will allow us to validate the information against our language type
	@RequestMapping("/new")
	public String newLanguage(@ModelAttribute("language")Language language) {
		return "new.jsp";
	}
	//write the route to check if the submitted post has any errors
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String createLanguage(@Valid @ModelAttribute("langauge")Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		else {
			languageService.createLanguage(language);
			return "redirect:/";
		}
	}
}
