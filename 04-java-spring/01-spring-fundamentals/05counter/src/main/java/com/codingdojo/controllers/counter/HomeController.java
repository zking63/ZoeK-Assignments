package com.codingdojo.controllers.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
    public String count(HttpSession session){
        // check if a key exists in session with the name "count"
        if(session.getAttribute("count") == null) {
            // no key found!  set session "count" to 0
            session.setAttribute("count", 0);
        }
        return "counter.jsp";
    }
    public String counter(HttpSession session){
        // first retrieve the current value in session, casting from Object to Integer
        Integer currentCount = (Integer) session.getAttribute("count");
        // increment count by 1
        currentCount++;
        // set the updated count value back into session
        session.setAttribute("count", currentCount);
    }
}
