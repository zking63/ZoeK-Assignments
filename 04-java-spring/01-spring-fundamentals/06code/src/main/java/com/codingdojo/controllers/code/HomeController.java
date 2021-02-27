package com.codingdojo.controllers.code;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class HomeController {
	@RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
	@RequestMapping(path="/attempt", method=RequestMethod.POST)
	public String attempt(@RequestParam(value="code") String code, Model model, RedirectAttributes rAttributes) {
		if (code.equals("bushido")) {
			return "redirect:/login";
		}
		else {
			rAttributes.addFlashAttribute("error", "that code was incorrect");
			return "redirect:/";	
		}
	}
	@RequestMapping("/login")
    public String login() {
        return "login.jsp";
    }
}
