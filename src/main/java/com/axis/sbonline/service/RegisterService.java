package com.axis.sbonline.service;

import java.util.List;

import com.axis.sbonline.model.User;

public interface RegisterService {
	
	public void addUser(User user);
	public List<User> fetchAll();
	public User getByUsername(String username);
}
