package com.codingdojo.controllers.ninjagold;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		ArrayList<String> activityLog = new ArrayList<String>();
		//session is a hashmap that isn't visible to the user
		if(session.getAttribute("gold") ==  null) {
			session.setAttribute("gold", 55);
		}
		if(session.getAttribute("activity") == null) {
			session.setAttribute("activity", activityLog);
		}
		model.addAttribute("totalgold", session.getAttribute("gold"));
		model.addAttribute("activityLog", session.getAttribute("activity"));
		return "index.jsp";
	}
	@PostMapping("/processGold") //post mapping is getting from front end and bringing to back
	public String addGold(@RequestParam("building") String building, HttpSession session) {
		int gold = (int)session.getAttribute("gold");
		ArrayList<String> activityLog = (ArrayList<String>)session.getAttribute("activity");
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
		int goldThisTurn;
		if(building.equals("farm")) {
			//((max - min)+1)+10
			goldThisTurn = r.nextInt((20-10) +1) +10;
			activityLog.add("You entered a farm and got " + goldThisTurn + " gold " + formatter.format(now));
		}
		else if(building.equals("cave")) {
			goldThisTurn = r.nextInt((10-5) +1) +5;
			System.out.println(goldThisTurn);
			activityLog.add("You entered a cave and got " + goldThisTurn + " gold " + formatter.format(now));
		}
		else if(building.equals("house")) {
			goldThisTurn = r.nextInt((5-2) +1) +2;
			System.out.println(goldThisTurn);
			activityLog.add("You entered a house and got " + goldThisTurn + " gold " + formatter.format(now));
		}
		else {
			//different random formula because it is a negative int (you can lose/earn 50 here)
			goldThisTurn = r.nextInt((50+50) +1) -50;
			System.out.println(goldThisTurn); 
			if (goldThisTurn < 0) {
				activityLog.add("You entered a casino and lost " + (goldThisTurn * -1) + " gold " + formatter.format(now));
			}
			else {
				activityLog.add("You entered a casino and got " + goldThisTurn + " gold " + formatter.format(now));
			}
		}
		session.setAttribute("gold", gold + goldThisTurn);
		session.setAttribute("activity", activityLog);
		return "redirect:/";
	}
	@GetMapping("/logout")
	public String seshClear(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
