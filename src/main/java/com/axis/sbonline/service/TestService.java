package com.axis.sbonline.service;

import java.util.List;

import com.axis.sbonline.model.CTest;
import com.axis.sbonline.model.Question;
import com.axis.sbonline.model.Report;
import com.axis.sbonline.model.ShowReport;
import com.axis.sbonline.model.Subject;
import com.axis.sbonline.model.User;
import com.axis.sbonline.model.UserAnswer;
import com.axis.sbonline.model.UserResponse;

public interface TestService {

		public CTest generateTest(int userId, int subjectId,int level);
		public Subject getSubject(int subjectId);
		public User getUser(int userId);
		public List<Question> getQuestions(int testId,int level);
		public UserAnswer storeResponse(UserResponse response);
		public UserAnswer alterResponse(int userAnswerId,String optionChosen,int questionId);
		public Report generateReport(int userId,int testId,int totalMarks);
		public ShowReport getReportDetails(int reportId);
		public List<Report> getAllreportForUser(int userId);
			
}