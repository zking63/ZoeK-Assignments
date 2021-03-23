package com.codingdojo.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.events.models.Events;

@Repository
public interface EventRepo extends CrudRepository<Events, Long>{
	List<Events> findAll();
	List<Events> findByeventState(String eventState);
	List<Events> findByeventStateIsNot(String eventState);
}
