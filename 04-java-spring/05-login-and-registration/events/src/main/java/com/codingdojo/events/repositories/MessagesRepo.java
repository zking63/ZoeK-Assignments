package com.codingdojo.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.events.models.Messages;

public interface MessagesRepo extends CrudRepository<Messages, Long>{
	List<Messages>findAll();
}
