package com.codingdojo.DojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.DojoOverflow.models.Question;

public interface QuestionRepo extends CrudRepository<Question, Long>{
	List<Question> findAll();
}
