package com.codingdojo.DojoOverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.DojoOverflow.models.Answers;
import com.codingdojo.DojoOverflow.models.Question;
import com.codingdojo.DojoOverflow.models.Tag;
import com.codingdojo.DojoOverflow.repositories.AnswersRepo;
import com.codingdojo.DojoOverflow.repositories.QuestionRepo;
import com.codingdojo.DojoOverflow.repositories.TagRepo;

@Service
public class DojoService {
	private final QuestionRepo qrepo;
	private final TagRepo trepo;
	private final AnswersRepo arepo;
	public DojoService (QuestionRepo qrepo, TagRepo trepo, AnswersRepo arepo) {
		this.qrepo = qrepo;
		this.trepo = trepo;
		this.arepo = arepo;
	}
	
	public List<Tag> getTags() {
		return trepo.findAll();
	}
	public List<Question> getQuestions() {
		return qrepo.findAll();
	}
	public List<Answers> getAnswers(){
		return arepo.findAll();
	}
	public Question createQuestion(Question q) {
		return qrepo.save(q);
	}
	public Answers createAnswer(Answers a) {
		return arepo.save(a);
	}
	public Tag createOrRetreive(String subject) {
		Optional<Tag> mightExist = trepo.findBySubject(subject);
		if (mightExist.isPresent()) {
			return mightExist.get();
		} else {
			return trepo.save(new Tag(subject));
		}
	}

	public Question CreateQuestionWithTags(Question newQuestionPlus) {
		List<Tag> tag = new ArrayList<Tag>();
		for (String subject : newQuestionPlus.getTagsInput().split(",")) {
			tag.add(createOrRetreive(subject));
		}
		newQuestionPlus.setTags(tag);
		return qrepo.save(newQuestionPlus);
	}
	public Question getQuestion(Long id) {
		return this.qrepo.findById(id).orElse(null);
	}
	public Answers getAnswer(Long id) {
		return this.arepo.findById(id).orElse(null);
	}
	public Question updateQuestion(Question q) {
		return qrepo.save(q);
	}
}
