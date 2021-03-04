package com.codingdojo.languages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguagesRepository;

@Service
public class LanguageService {
	 private final LanguagesRepository languagesRepository;
	 
	 public LanguageService(LanguagesRepository languagesRepository) {
	     this.languagesRepository = languagesRepository;
	 }
	 public List<Language> allLanguages(){
		 return languagesRepository.findAll();
	 }
	 // creates an object
	 public Language createLanguage(Language a) {
	     return languagesRepository.save(a);
	 }
	 // retrieves an object by id
	public Language findLanguage(Long id) {
		return languagesRepository.findById(id).orElse(null);
	}
	public Language updateLanguage(Language language) {
		return languagesRepository.save(language);
	}
	public void deleteLanguage(Long id) {
		languagesRepository.deleteById(id);
	}
}
