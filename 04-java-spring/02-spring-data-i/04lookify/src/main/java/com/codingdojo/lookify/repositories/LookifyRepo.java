package com.codingdojo.lookify.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.codingdojo.lookify.models.Lookify;

public interface LookifyRepo extends CrudRepository<Lookify, Long>{
	 // this method retrieves all the books from the database
	List<Lookify> findAll();
	Optional<Lookify> findById(Long id);
	List<Lookify> findByArtistContaining(String artist);
	List<Lookify> findTop10ByOrderByRatingDesc();
}
