package com.axis.sbonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.sbonline.model.User;

public interface RegisterRepo extends JpaRepository<User, Integer> {
	
}
