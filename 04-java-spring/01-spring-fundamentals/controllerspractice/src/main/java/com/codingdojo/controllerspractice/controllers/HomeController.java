package com.codingdojo.controllerspractice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//practicing using controllers 

@RestController //combo of controller annotation and response body annotation, use controller when you want to have a view (html or jsp) as response; restcontroller responds with data.
@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("")
	public String hello() {
		return "hello world";
	}
	@RequestMapping("/world")
	public String world() {
		return "class level annotations";
	}
}
