package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.repositories.LookifyRepo;

@Service
public class LookifyService {
	 private final LookifyRepo lookifyRepo;
	 
	 public LookifyService(LookifyRepo lookifyRepo) {
	     this.lookifyRepo = lookifyRepo;
	 }
	 
	 public List<Lookify> allSongs(){
		 return lookifyRepo.findAll();
	 }
	 public Lookify newSong(Lookify b){
		 return lookifyRepo.save(b);
	 }
	 public Lookify findId(Long id) {
	     Optional<Lookify> optionalSong = lookifyRepo.findById(id);
	     if(optionalSong.isPresent()) {
	         return optionalSong.get();
	     } else {
	         return null;
	     }
	 }
	 public void deleteSong(Long id) {
		lookifyRepo.deleteById(id);
	 }
	 public List<Lookify> findArtists(String artist) {
		return lookifyRepo.findByArtistContaining(artist);
	 }
	 public List<Lookify> find10() {
		return lookifyRepo.findTop10ByOrderByRatingDesc();
	 }
}
