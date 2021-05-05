package com.axis.sbonline.service;

import java.util.List;

import com.axis.sbonline.model.Question;
import com.axis.sbonline.model.Subject;

public interface AdminService {

	public void addSubject(Subject subject);

	public int addQuestion(Question question);
	public Subject getSubject(int subId);

	public List<Question> getQuestions(int subId);
	
	public void deleteQuestion(int quesId);

}
