package com.codingdojo.DojoOverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.DojoOverflow.models.Answers;

public interface AnswersRepo extends CrudRepository <Answers, Long>{
	List<Answers> findAll();
}