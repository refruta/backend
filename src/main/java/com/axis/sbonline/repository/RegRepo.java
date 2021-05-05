package com.axis.sbonline.repository;

import java.util.List;

import com.axis.sbonline.model.User;

public interface RegRepo {
	public void addUser(User user);
	public User getUserByUsername(String username);

	public List<User> fecthAll();
}
