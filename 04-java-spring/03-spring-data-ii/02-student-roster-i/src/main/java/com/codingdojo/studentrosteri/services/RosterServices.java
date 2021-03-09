package com.codingdojo.studentrosteri.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.studentrosteri.models.Dojo;
import com.codingdojo.studentrosteri.models.Ninja;
import com.codingdojo.studentrosteri.repositiories.DojoRepo;
import com.codingdojo.studentrosteri.repositiories.NinjaRepo;

@Service
public class RosterServices {
	private final DojoRepo drepo;
	private final NinjaRepo nrepo;
	
	public RosterServices(DojoRepo drepo, NinjaRepo nrepo) {
		this.nrepo = nrepo;
		this.drepo = drepo;
	}
	public List<Dojo> listDojos(){
		return drepo.findAll();
	}
	public List<Ninja> listNinjas(){
		return nrepo.findAll();
	}
	public Dojo createDojo(Dojo d) {
		return drepo.save(d);
	}
	public Ninja createNinja(Ninja d) {
		return nrepo.save(d);
	}
	public Dojo findDojo(Long id) {
		return drepo.findById(id).orElse(null);
	}
	public void deleteNinja(Long id) {
		nrepo.deleteById(id);
	}
}
