package com.codingdojo.controllers.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dojo")
public class DojoController {
	@RequestMapping
	public String dojo() {
		return "The dojo is awesome.";
	}
	@RequestMapping("/{location}")
	public String burbank(@PathVariable("location") String location) {
		switch(location) {
		case "burbank":
			return "Burbank is where";
		case "san-jose":
			return "SJ is where";
		default:
			return String.format("%s is pretty sweet!", location);
		}
	}
}
