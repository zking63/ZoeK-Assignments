package com.codingdojo.studentrosteri.repositiories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.studentrosteri.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}
