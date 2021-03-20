package com.codingdojo.DojoOverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.DojoOverflow.models.Tag;

public interface TagRepo extends CrudRepository<Tag, Long>{
	List<Tag> findAll();

	Optional<Tag> findBySubject(String subject);
}
