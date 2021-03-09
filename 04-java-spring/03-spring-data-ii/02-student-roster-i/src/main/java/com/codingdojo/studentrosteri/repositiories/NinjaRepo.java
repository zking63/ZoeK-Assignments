package com.codingdojo.studentrosteri.repositiories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.studentrosteri.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
