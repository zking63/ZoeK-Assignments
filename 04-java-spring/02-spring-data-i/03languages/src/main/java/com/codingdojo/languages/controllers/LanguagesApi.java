package com.codingdojo.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@RestController
public class LanguagesApi {
	 private LanguageService languageService;
	 public LanguagesApi(LanguageService languageService){
	     this.languageService = languageService;
	 }
	 @RequestMapping("/api/languages")
	 public List<Language> index() {
	     return this.languageService.allLanguages();
	 }
	 @RequestMapping(value="/api/languages", method=RequestMethod.POST)
	 public Language create(@RequestParam(value="name") String name, @RequestParam(value="currentVersion") String currentVersion, @RequestParam(value="creator") String creator) {
	     Language language = new Language(name, currentVersion, creator);
	     return languageService.createLanguage(language);
	 }
	 @RequestMapping("/api/languages/{id}")
	 public Language show(@PathVariable("id") Long id) {
	     Language language = languageService.findLanguage(id);
	     return language;
	 }
}
