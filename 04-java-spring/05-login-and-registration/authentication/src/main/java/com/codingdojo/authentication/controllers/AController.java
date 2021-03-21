package com.codingdojo.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.services.UserService;
import com.codingdojo.authentication.validators.UserValidation;

@Controller
public class AController {
 private final UserService userService;
 private final UserValidation uservalidator;
 
 public AController(UserService userService, UserValidation uservalidator) {
     this.userService = userService;
     this.uservalidator = uservalidator;
 }
 
 @RequestMapping("/registration")
 public String registerForm(@ModelAttribute("user") User user) {
     return "registrationPage.jsp";
 }
 @RequestMapping("/login")
 public String login() {
     return "loginPage.jsp";
 }
 
 @RequestMapping(value="/registration", method=RequestMethod.POST)
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {	
	 //validate the passwords - call on validation, use validate method, take in user to validate it, take in result append any errors to the result to include that to the errors check below
	 uservalidator.validate(user, result);
     // if result has errors, return the registration page
	 if (result.hasErrors()) {
		 return "registrationPage.jsp";
	 }
     // else, save the user in the database, save the user id in session, and redirect them to the /home route
	 User newUser = userService.registerUser(user);
	 //setting user in session
	 session.setAttribute("user_id", newUser.getId());
	 //returning to home
	 return "redirect:/home";
 }
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
     // if the user is authenticated, save their user id in session
	 boolean isAuthenticated = userService.authenticateUser(email, password);
	 if(isAuthenticated) {
		 User u = userService.findByEmail(email);
		 session.setAttribute("user_id", u.getId());
		 return "redirect:/home";
	 }
     // else, add error messages and return the login page
	 else {
		 model.addAttribute("error", "Invalid credentials please try again.");
		 return "loginPage.jsp";
	 }
 }
 
 @RequestMapping("/home")
 public String home(HttpSession session, Model model) {
	 //only open for users
	 if (session.getAttribute("user_id") == null) {
		 return "redirect:/login";
	 }
	 //show email on homepage
	 //cast user_id into long - always have to typecast session
	 Long userId = (Long) session.getAttribute("user_id");
	 //find user by the userId
	 User u = userService.findUserById(userId);
	 //add user to homepage
	 model.addAttribute("user", u);
	 //return homepage
     return "homePage.jsp";
 }
 @RequestMapping("/logout")
 public String logout(HttpSession session) {
     // invalidate session
	 session.invalidate();
     // redirect to login page
	 return "redirect:/login";
 }
}
