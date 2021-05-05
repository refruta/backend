package com.axis.sbonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.sbonline.model.User;
import com.axis.sbonline.repository.RegRepoImpl;
import com.axis.sbonline.repository.RegisterRepo;

@Service
public class RegisterServiceImpl implements RegisterService{

	
	@Autowired
	RegRepoImpl repo1;
	
	@Override
	public void addUser(User user) {
		repo1.addUser(user);
	}


	public User getByUsername(String username){
		return repo1.getUserByUsername(username);
	}
	
	@Override
	public List<User> fetchAll(){
		return repo1.fecthAll();
	}


}
