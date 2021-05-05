package com.axis.sbonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.sbonline.model.Question;
import com.axis.sbonline.model.Subject;
import com.axis.sbonline.repository.AdminRepo;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminRepo repo1;

	@Override
	public void addSubject(Subject subject) {
		repo1.addSub(subject);
	}

	@Override
	public int addQuestion(Question question) {
		repo1.addQuestion(question);
		return question.getQuestionId();
	}
	
	@Override
	public Subject getSubject(int subId) {
		return repo1.getSubject(subId);
	}

	@Override
	public List<Question> getQuestions(int subId) {
	return repo1.fetchQuestions(subId);
	}

	@Override
	public void deleteQuestion(int quesId) {
		repo1.deleteQuestion(quesId);
		System.out.println("Deleted");
	}

}
