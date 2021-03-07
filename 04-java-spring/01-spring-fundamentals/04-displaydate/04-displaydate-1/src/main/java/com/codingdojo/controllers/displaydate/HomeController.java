package com.codingdojo.controllers.displaydate;

import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String showDate(Model model) {
		Date date = new Date();
		SimpleDateFormat dm = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY");
		model.addAttribute("rightNow", dm.format(date));
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String showTime(Model model) {
		Date time = new Date();
		SimpleDateFormat dm = new SimpleDateFormat("h:mm a");
		model.addAttribute("rightNow", dm.format(time));
		return "time.jsp";
	}
}
