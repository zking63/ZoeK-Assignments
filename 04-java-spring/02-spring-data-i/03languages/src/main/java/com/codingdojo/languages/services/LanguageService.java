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
	 
	 private List<Language> languages = new ArrayList(Arrays.asList(
			 new Language("Java", "James G", (float) 1.8),
			 new Language("Python", "Guido van R", (float) 3.6),
			 new Language("Javascript", "Brendan Eich", (float) 2.8)
			 ));
	 public List<Language> allLanguages(){
		 return languages;
	 }
	 // creates an object
	 public Language createLanguage(Language a) {
	     return languagesRepository.save(a);
	 }
	 // retrieves an object
	 public Language findLanguage(Long id) {
	     Optional<Language> optionalLanguage = languagesRepository.findById((long) id);
	     if(optionalLanguage.isPresent()) {
	         return optionalLanguage.get();
	     } else {
	         return null;
	     }
	 }
	 public void addLanguage(Language language) {
		    languages.add(language);
		}
}
