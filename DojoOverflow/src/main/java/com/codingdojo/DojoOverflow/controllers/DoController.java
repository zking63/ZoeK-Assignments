package com.codingdojo.DojoOverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.DojoOverflow.models.Answers;
import com.codingdojo.DojoOverflow.models.Question;
import com.codingdojo.DojoOverflow.services.DojoService;

@Controller
public class DoController {
	private final DojoService dservice;
	public DoController(DojoService dservice) {
		this.dservice = dservice;
	}
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("question", dservice.getQuestions());
		model.addAttribute("tag", dservice.getTags());
		return "index.jsp";
	}
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question")Question question) {
		return "/questions/newquestion.jsp";
	}
	@RequestMapping(value="/questions", method=RequestMethod.POST)
	public String createQuestion(@Valid @ModelAttribute("question")Question question, BindingResult result) {
		if (result.hasErrors()){
			return "/questions/newquestion.jsp";
		}
		else {
			dservice.CreateQuestionWithTags(question);
			return "redirect:/";
		}
	}
	/*@PostMapping("/answer/new")
	public String createAnswer(@Valid @ModelAttribute("answers") Answers answers, BindingResult result, Model model, @RequestParam("questionId") Long questionId) {
		if (result.hasFieldErrors()) {
			model.addAttribute("question", dservice.getQuestion(questionId));
			return "/questions/" + questionId;
		} else {
			dservice.createAnswer(answers);
			return "redirect:/questions" + questionId;
		}
	}*/
	@PostMapping("/answer/new")
	public String createAnswer(@Valid @ModelAttribute("answers") Answers answers, BindingResult result) {
		if(result.hasErrors()) {
			return "questions/show.jsp";
		}
		Answers newAnswer = dservice.createAnswer(answers);
		return "redirect:/questions/" + newAnswer.getQuestion().getId();
	}
	@RequestMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model) {
		model.addAttribute("question", dservice.getQuestion(id));
		model.addAttribute("answers", new Answers());
		return "/questions/show.jsp";
	}
	/*@PostMapping("/questions/{id}")
	public String attachAnswers(@RequestParam("answers")Long aId, @PathVariable("id") Long id) {
		//get question
		Question question = dservice.getQuestion(id);
		//get answers
		List<Answers> answers1 = dservice.getQuestion(id).getAnswers();
		//create Answers 
		//set answer
		//Answers answer = dservice.getAnswer(aId);
		answers1.add(answer);
		//update question with answer
		dservice.updateQuestion(question);
		return "redirect:/";
	}*/
}
