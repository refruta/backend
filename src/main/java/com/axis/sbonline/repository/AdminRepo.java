package com.axis.sbonline.repository;

import java.util.List;

import com.axis.sbonline.model.Question;
import com.axis.sbonline.model.Subject;

public interface AdminRepo {
	public void  addSub(Subject sub);
	public Subject getSubject(int subId);
	public void addQuestion(Question question);
	public List<Question> fetchQuestions(int subId);
	public void deleteQuestion(int quesId);
}
