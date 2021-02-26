package com.codingdojo.controllers.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.ui.Model;

public class HomeController {
	@RequestMapping("/")
	public String index() {
		//Date date = new Date();
		//model.addAttribute("rightNow", date);
		return "index.jsp";
	}
}
