package com.axis.sbonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.sbonline.exception.ResourceNotFoundException;
import com.axis.sbonline.model.CTest;
import com.axis.sbonline.model.CreateReport;
import com.axis.sbonline.model.Question;
import com.axis.sbonline.model.Report;
import com.axis.sbonline.model.ShowReport;
import com.axis.sbonline.model.Subject;
import com.axis.sbonline.model.User;
import com.axis.sbonline.model.UserAnswer;
import com.axis.sbonline.model.UserResponse;
import com.axis.sbonline.service.TestService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestService service ; 

	@GetMapping("/getSubj/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Subject getSub(@PathVariable int id) throws ResourceNotFoundException{
	      if(service.getSubject(id) != null) {
	    	  return service.getSubject(id);
	     }
	      else {
	    	  throw new ResourceNotFoundException("No subject with id "+id);
	      }
	}

	@GetMapping("/getUser/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public User getUser(@PathVariable int id) throws ResourceNotFoundException{
	        if(service.getUser(id) != null) {
	        	return service.getUser(id);
	        }
	        else {
		    	  throw new ResourceNotFoundException("No user with id "+id);
	        }
	}
	@PostMapping("/start-test/{userId}/{subjectId}/{level}")
	@PreAuthorize("hasRole('ADMIN')")
	    public int startTest(@PathVariable int userId, @PathVariable int subjectId, @PathVariable int level)
	    {
	        CTest testId = service.generateTest(userId, subjectId, level);
	        return testId.getTestId();
	    }

	@GetMapping("/getQuestions/{testId}/{level}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	    public List<Question> getQuestion(@PathVariable int testId, @PathVariable int level) throws ResourceNotFoundException {
	        if(service.getQuestions(testId, level) !=null) {
	        	return service.getQuestions(testId, level);
	        }else {
	        	throw new ResourceNotFoundException("No Questions with test id"+testId);
	        }
	    }

	@PostMapping("/create-response")
	@PreAuthorize("hasRole('USER')")
	    @ResponseBody
	    public UserAnswer storeResponse(@RequestBody UserResponse response) {
	        return service.storeResponse(response);
	    }
	
	@PostMapping("/alter/{userAnswerId}/{optionChosen}/{questionId}")
	@PreAuthorize("hasRole('USER')")
	@ResponseBody
	    public UserAnswer alterResponse( @PathVariable int userAnswerId, @PathVariable String optionChosen ,@PathVariable int questionId
	    ) {
	        return service.alterResponse(userAnswerId, optionChosen, questionId);
	    }

	    @PostMapping("/create-report")
		@PreAuthorize("hasRole('ADMIN')")
	    @ResponseBody
	    public Report generateReport(@RequestBody CreateReport rep) {
	        return service.generateReport(rep.getUserId(), rep.getTestId(), rep.getTotalMarks());
	    }

	    @GetMapping("/report-details/{repId}")
		@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	    public ShowReport getReportDetails(@PathVariable int repId ){
	        return service.getReportDetails(repId);
	    }
	    @GetMapping("/getAllReportsForUser/{userId}")
		@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	    public List<Report> getAllReportsForUser(@PathVariable int userId) throws ResourceNotFoundException {
	         if(service.getAllreportForUser(userId) != null) {
	        	 return service.getAllreportForUser(userId);
	        }
	         else {
	        	 throw new ResourceNotFoundException("No Reports For user id "+userId);
	         }
	    }

}
