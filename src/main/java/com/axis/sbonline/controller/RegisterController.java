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
import org.springframework.web.bind.annotation.RestController;

import com.axis.sbonline.model.User;
import com.axis.sbonline.service.RegisterService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/find")
public class RegisterController {

	@Autowired
	RegisterService service;
	@GetMapping("/getUser")
	public List<User> fetchAll() {
		return service.fetchAll();
	}
	
	@GetMapping("/getByUsername/{username}")
	public User getByEmail(@PathVariable String username) {
		return service.getByUsername(username);
	}
}
