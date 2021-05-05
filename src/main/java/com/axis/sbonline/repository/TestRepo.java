package com.axis.sbonline.repository;

import java.util.List;

import com.axis.sbonline.model.CTest;
import com.axis.sbonline.model.Question;
import com.axis.sbonline.model.Subject;
import com.axis.sbonline.model.User;
import com.axis.sbonline.model.UserAnswer;

public interface TestRepo {

	public void createTest(CTest test);
	public void addResponse(UserAnswer response);
	public UserAnswer getUserAnswer(int userAnswerId);
	public Subject getSubject(int subId);	
	public User getUser(int userId);
	public CTest getTest(int testId);
	public Question getQuestion(int questionId);
	public List<Question> fetchQuestions(int subId,int level);
}
