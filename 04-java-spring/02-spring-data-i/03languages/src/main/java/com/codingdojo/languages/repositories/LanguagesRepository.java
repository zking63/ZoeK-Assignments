package com.codingdojo.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.languages.models.Language;

@Repository
public interface LanguagesRepository extends CrudRepository<Language, Long> {
	 // this method retrieves all the books from the database
	List<Language> findAll();
}
