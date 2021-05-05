package com.axis.sbonline.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.axis.sbonline.model.User;

@Repository
public class RegRepoImpl implements RegRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public void addUser(User user) {
		this.entityManager.persist(user);
	}

	@Transactional
	@Override
	public User getUserByUsername(String username) {
		String s = "select u from User u where u.username=:e";
		Query q = entityManager.createQuery(s);
		q.setParameter("e", username);
		return (User) q.getSingleResult();
	}

	@Transactional
	@Override
	public List<User> fecthAll(){
		String s = "select u from User u";
		Query q = entityManager.createQuery(s);
		return q.getResultList();
	}
}
