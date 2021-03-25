package com.codingdojo.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.events.models.Events;
import com.codingdojo.events.models.Messages;
import com.codingdojo.events.models.User;
import com.codingdojo.events.repositories.EventRepo;
import com.codingdojo.events.repositories.MessagesRepo;

@Service
public class EventsService {
	@Autowired
	private EventRepo erepo;
	@Autowired
	private MessagesRepo mrepo;
	
	public Events createEvent(Events event) {
		return erepo.save(event);
	}
	public List<Events> allEventsWithState(String state) {
		return erepo.findByeventState(state);
	}
	public List<Events> allEventsWithoutState(String state) {
		return erepo.findByeventStateIsNot(state);
	}
	public Events findbyId(Long id) {
		return erepo.findById(id).orElse(null);
	}
	public void delete(Long id) {
		erepo.deleteById(id);
	}
	public Messages comment(User user, Events event, String comment) {
		Messages message = new Messages(user, event, comment);
		return this.mrepo.save(message);
	}
}
