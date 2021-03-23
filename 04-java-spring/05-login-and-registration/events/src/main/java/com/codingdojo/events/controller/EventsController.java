package com.codingdojo.events.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	 @RequestMapping("/home")
	 public String EventsPage(@ModelAttribute("event") Events event, Model model, HttpSession session) {
		 Long user_id = this.userSessionId(session);
		 if (user_id == null) {
			 return "redirect:/";
		 }
		 User user = uservice.findUserbyId(user_id);
		 model.addAttribute("user", user);
		 return "events.jsp";
	 }
}
