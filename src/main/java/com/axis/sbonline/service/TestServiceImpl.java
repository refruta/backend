package com.axis.sbonline.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.sbonline.model.CTest;
import com.axis.sbonline.model.Question;
import com.axis.sbonline.model.Report;
import com.axis.sbonline.model.ShowReport;
import com.axis.sbonline.model.Subject;
import com.axis.sbonline.model.User;
import com.axis.sbonline.model.UserAnswer;
import com.axis.sbonline.model.UserResponse;
import com.axis.sbonline.repository.GenerateRepo;
import com.axis.sbonline.repository.TestRepo;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestRepo testDao;

	@Autowired
	private GenerateRepo gr;

	@Override
	public CTest generateTest(int userId, int subjectId, int level) {
        CTest test = new CTest();
        Subject subject = testDao.getSubject(subjectId);
        User user = testDao.getUser(userId);
        test.setSubject(subject) ;
        test.setLevel(level);
        test.setDateAndTimeOfTest(LocalDateTime.now());
        test.setUser(user);
        testDao.createTest(test);
        return test;
	}

	@Override
	public Subject getSubject(int subjectId) {
		return testDao.getSubject(subjectId);
	}

	@Override
	public User getUser(int userId) {
		return testDao.getUser(userId);
	}

	@Override
	public List<Question> getQuestions(int testId, int level) {
        CTest test = testDao.getTest(testId);
        return testDao.fetchQuestions(test.getSubject().getSubject_id(),level);
	}

	@Override
	public UserAnswer storeResponse(UserResponse response) {
        CTest test = testDao.getTest(response.getTestId());
        Question ques = testDao.getQuestion(response.getQuestionId());
        UserAnswer ur = new UserAnswer();
        ur.setOptionChosen(response.getOptionChosen());
        ur.setQuestion(ques);
        ur.setTest(test); 
        ur.setUid(response.getUid());
        int marks = 0;
        if(response.getOptionChosen().equalsIgnoreCase(ques.getCorrectAnswer())){
            marks = ques.getMarks();
            System.out.println(marks);
        } else {
            marks = 0;
        }
        ur.setMarksObtained(marks);
        testDao.addResponse(ur);
        return  ur;
	}

	@Override
	public UserAnswer alterResponse(int userAnswerId, String optionChosen1, int questionId) {
        Question ques = testDao.getQuestion(questionId);
        UserAnswer ua = testDao.getUserAnswer(userAnswerId);
        ua.setOptionChosen(optionChosen1);
        int marks = 0;
        if (ua.getOptionChosen().equalsIgnoreCase(ques.getCorrectAnswer())) {
            marks = ques.getMarks();
            System.out.println(marks);
        } else {
            marks = 0;
            System.out.println(marks);
        }
        ua.setMarksObtained(marks);
        testDao.addResponse(ua);
        return  ua;
	}

	@Override
	public Report generateReport(int userId, int testId, int totalMarks) {
		 			Report report =new Report();
		 			report.setUser(testDao.getUser(userId));
			        report.setTest(testDao.getTest(testId));
			        int marks = 0;
			        List<Integer>Marks = gr.getMarksById(userId);
			        for (int l: Marks) {
			            marks += l;
			        }
			        report.setTestScore(marks);
			        report.setTotalScore(totalMarks);
			        System.out.println("marks"+ marks+" out of "+ totalMarks);
			        float percentage = (marks * 100 / totalMarks);
			        System.out.println("percentage" + percentage);
			        if (percentage >= 60.0) {
			            report.setClearedLevel(report.getTest().getLevel());
			        } else {
			            report.setClearedLevel(report.getTest().getLevel()-1);
			        }
			        gr.addReport(report);
			        return  report;
		
	}

	@Override
	public ShowReport getReportDetails(int reportId) {
	    Report rep = gr.getReport(reportId);
	            ShowReport showrep = new ShowReport();

	            showrep.setName(rep.getUser().getName());
	            showrep.setEmail(rep.getUser().getEmail());
	            showrep.setDateAndTimeOfTest(rep.getTest().getDateAndTimeOfTest());
	            showrep.setLevel(rep.getClearedLevel());
	            showrep.setSubjecName(rep.getTest().getSubject().getSubjectName());
	            showrep.setTestScore(rep.getTestScore());;
	            showrep.setTotalScore(rep.getTotalScore());
	            
	            return  showrep;
	       	}

	@Override
	public List<Report> getAllreportForUser(int userId) {
	     List<Report> reports = gr.getAllReportsByUser(userId);
	     return reports;
	}
	
	
}
