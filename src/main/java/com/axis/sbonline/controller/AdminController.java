package com.axis.sbonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.sbonline.exception.ResourceNotFoundException;
import com.axis.sbonline.model.Question;
import com.axis.sbonline.model.Subject;
import com.axis.sbonline.service.AdminService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService service;
	
	@PostMapping("/addSub")
	@PreAuthorize("hasRole('ADMIN')")
	public void addSub(@RequestBody Subject subject) {
		service.addSubject(subject);
		System.out.println("Added");
	}
	
	@GetMapping("/getSubj/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Subject getSub(@PathVariable int id) throws ResourceNotFoundException {
		if(service.getSubject(id) != null) {
			return service.getSubject(id);
		}
		else {
			throw new ResourceNotFoundException("No subject found for the id "+id);
		}
	
	}
	@PostMapping("/addQuestion/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void addQuestion(@RequestBody Question question,@PathVariable int id) {
		id = id;
		Subject subject = service.getSubject(id);
		question.setSubject(subject);
		service.addQuestion(question);
		question.setSubject(subject);
		System.out.println("added");
	}

	@GetMapping("/getQuestion/{subId}")
	@PreAuthorize("hasRole('ADMIN')")
    public List<Question> getQuestion(@PathVariable int subId) throws ResourceNotFoundException {
         if(!service.getQuestions(subId).isEmpty()) {
        	 return service.getQuestions(subId);
        }else {
        	throw  new ResourceNotFoundException("No Question found for the id "+subId); 
        }
    }
	
	@DeleteMapping("deleteQuestion/{quesId}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteQuestion(@PathVariable int quesId) {
	        service.deleteQuestion(quesId);
	  }
}
