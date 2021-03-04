package com.codingdojo.languages.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {
	private LanguageService languageService;
	public LanguageController(LanguageService languageService){
	    this.languageService = languageService;
	}
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("Languages", languageService.allLanguages());
		return "index.jsp";
	}
}
