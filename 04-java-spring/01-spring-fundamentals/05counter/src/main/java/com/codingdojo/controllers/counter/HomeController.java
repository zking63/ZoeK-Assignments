package com.codingdojo.controllers.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	   public String home(HttpSession session){
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
     Integer count = (Integer) session.getAttribute("count");
		count += 1;
		session.setAttribute("count", count);
		return "index.jsp";

	}
	@RequestMapping("/counter")
	public String Counter(HttpSession session, Model model) {
		model.addAttribute("counter");
		return "counter.jsp";
	}
}
