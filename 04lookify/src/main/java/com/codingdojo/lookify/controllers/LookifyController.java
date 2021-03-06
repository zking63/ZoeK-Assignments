package com.codingdojo.lookify.controllers;

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

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.services.LookifyService;

@Controller
public class LookifyController {
	//dependency inject service
	private final LookifyService lookifyService;
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/songs")
	public String index(Model model) {
		model.addAttribute("songs", lookifyService.allSongs());
		return "/songs/songs.jsp";
	}
	@RequestMapping("/songs/new")
	public String newSong1(@ModelAttribute("song")Lookify song) {
		return "/songs/new.jsp";
	}
	@RequestMapping(value="/songs", method=RequestMethod.POST)
    public String createSong(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/new.jsp";
        }else{
        	lookifyService.newSong(song);
            return "redirect:/songs";
        }
    }
	@RequestMapping("/songs/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", lookifyService.findId(id));
		return "/songs/id.jsp";
	}
	@RequestMapping("/songs/delete/{id}")
	public String Delete(@PathVariable("id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/songs";
	}
	@RequestMapping("/songs/search")
	public String Search(@RequestParam("artist") String artist, Model model) {
		model.addAttribute("songs",	lookifyService.findArtists(artist));
		model.addAttribute("artist", lookifyService.findArtists(artist));
		return "/songs/searched.jsp";
	}
	@RequestMapping("/songs/top10")
	public String top10(Model model) {
		model.addAttribute("songs",	lookifyService.find10());
		return "/songs/top10.jsp";
	}
}
