package com.codingdojo.languages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguagesRepository;
import com.codingdojo.show.models.Book;

@Service
public class LanguageService {
	 private final LanguagesRepository languagesRepository;
	 
	 public LanguageService(LanguagesRepository languagesRepository) {
	     this.languagesRepository = languagesRepository;
	 }
	 
	 private List<Language> langauges = new ArrayList(Arrays.asList(
			 new Language("Java", "James G", "1.8"),
			 new Language("Python", "Guido van R", "3.6"),
			 new Language("Javascript", "Brendan Eich", "2.8.3")
			 ));
	 private List<Language> languages = new ArrayList(Arrays.asList(
	         new Language("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
	         new Language("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
	         new Language("Moby Dick", "The saga of Captain Ahab", "english", 544),
	         new Language("Don Quixote", "Life of a retired country gentleman", "english", 150),
	         new Language("The Odyssey", "Ancient Greek epic poem", "english", 475)
	         ));
	 public List<Language> allLanguages(){
		 return languages;
	 }
}
