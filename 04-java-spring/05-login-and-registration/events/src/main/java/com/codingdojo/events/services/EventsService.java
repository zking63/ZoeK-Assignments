package com.codingdojo.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.events.models.Events;
import com.codingdojo.events.models.User;
import com.codingdojo.events.repositories.EventRepo;

@Service
public class EventsService {
	@Autowired
	private EventRepo erepo;
	
	public Events createEvent(Events event) {
		return erepo.save(event);
	}
	public List<Events> allEventsWithState(String state) {
		return erepo.findByeventState(state);
	}
	public List<Events> allEventsWithoutState(String state) {
		return erepo.findByeventStateIsNot(state);
	}
}
