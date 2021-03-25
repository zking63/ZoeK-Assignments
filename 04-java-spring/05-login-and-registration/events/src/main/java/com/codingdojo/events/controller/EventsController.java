package com.codingdojo.events.controller;

import java.awt.Event;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.events.models.Events;
import com.codingdojo.events.models.User;
import com.codingdojo.events.services.EventsService;
import com.codingdojo.events.services.UserService;
import com.codingdojo.events.validation.UserValidation;

@Controller
public class EventsController {
	@Autowired
	private UserService uservice;
	@Autowired
	private UserValidation uvalidation;
	@Autowired
	private EventsService eservice;
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user")User user) {
		return "loginreg.jsp";
	}
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		uvalidation.validate(user, result);
		if (result.hasErrors()) {
			return "loginreg.jsp";
		}
		User newUser = uservice.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/home";
	}
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirs) {
	     // if the user is authenticated, save their user id in session
		 boolean isAuthenticated = uservice.authenticateUser(email, password);
		 if(isAuthenticated) {
			 User u = uservice.findUserbyEmail(email);
			 session.setAttribute("user_id", u.getId());
			 return "redirect:/home";
		 }
	     // else, add error messages and return the login page
		 else {
			 redirs.addFlashAttribute("error", "Invalid Email/Password");
			 return "redirect:/";
		 }
	 }
	public Long userSessionId(HttpSession session) {
		if(session.getAttribute("user_id") == null)
			return null;
		return (Long)session.getAttribute("user_id");
	}
	private String dateFormat() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
	 @RequestMapping("/home")
	 public String EventsPage(@ModelAttribute("event") Events event, Model model, HttpSession session) {
		 Long user_id = this.userSessionId(session);
		 if (user_id == null) {
			 return "redirect:/";
		 }
		 User user = uservice.findUserbyId(user_id);
		 model.addAttribute("user", user);
		 model.addAttribute("usersStates", this.eservice.allEventsWithState(user.getState()));
		 model.addAttribute("otherStates", this.eservice.allEventsWithoutState(user.getState()));
		 model.addAttribute("dateFormat", dateFormat());
		 return "events.jsp";
	 }
	 @RequestMapping(value="/home", method=RequestMethod.POST)
	 public String CreateEvent(@Valid @ModelAttribute("event") Events event, BindingResult result, Model model, HttpSession session) {
		 Long user_id = this.userSessionId(session);
		 User user = uservice.findUserbyId(user_id);
		 model.addAttribute("user", user);
		 if (result.hasErrors()) {
			 return "redirect:/home";
		 }
		 eservice.createEvent(event);
		 return "redirect:/home";
	 }
	 @RequestMapping("/{id}")
	 public String show(@PathVariable("id") Long id, Model model, HttpSession session, @ModelAttribute("event")Events event) {
		 Long user_id = this.userSessionId(session);
		 User user = uservice.findUserbyId(user_id);
		 if (user_id == null) {
			 return "redirect:/";
		 }
		 model.addAttribute("event", eservice.findbyId(id));
		 model.addAttribute("user", user);
		 return "show.jsp";
	 }
	@RequestMapping("/delete/{id}")
	public String Delete(@PathVariable("id") Long id) {
		this.eservice.delete(id);
		return "redirect:/home";
	}
	@RequestMapping(value="/edit/{id}")
	public String Edit(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long user_id = this.userSessionId(session);
		User user = uservice.findUserbyId(user_id);
		Events event = eservice.findbyId(id);
		if (user_id == null) {
			return "redirect:/";
		}
		if (event == null || user_id != event.getPlanner().getId()) {
			return "redirect:/home";
		}
		else {
			model.addAttribute("event", event);
			model.addAttribute("user", user);
			eservice.createEvent(event);
			return "edit.jsp";
		}
	}
	 @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	 public String Update(@Valid @ModelAttribute("event") Events event, BindingResult result, Model model, HttpSession session) {
		 Long user_id = this.userSessionId(session);
		 User user = uservice.findUserbyId(user_id);
		 model.addAttribute("user", user);
		 if (result.hasErrors()) {
			 return "redirect:/home";
		 }
		 eservice.createEvent(event);
		 return "redirect:/home";
	 }
	@PostMapping("/{id}/a/join")
	public String attendees(@PathVariable("id") Long id, HttpSession session) {
		Long user_id = this.userSessionId(session);
		//get event
		Events event = eservice.findbyId(id);
		//get attendees
		List<User> attendees = event.getAttendees();
		//set attendee
		User attendee = uservice.findUserbyId(user_id);
		attendees.add(attendee);
		//update event with attendee
		eservice.createEvent(event);
		return "redirect:/home";
	}
	/*@PostMapping("/{id}/a/cancel")
	public String removeAttendees(@PathVariable("id") Long id, HttpSession session) {
		Long user_id = this.userSessionId(session);
		//get event
		Events event = eservice.findbyId(id);
		//get attendees
		List<User> attendees = event.getAttendees();
		//set attendee
		User attendee = uservice.findUserbyId(user_id);
		attendees.remove(attendee);
		//update event without attendee
		eservice.createEvent(event);
		return "redirect:/home";
	}*/
}
