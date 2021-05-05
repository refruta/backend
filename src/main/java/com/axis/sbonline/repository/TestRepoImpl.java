package com.axis.sbonline.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.axis.sbonline.model.CTest;
import com.axis.sbonline.model.Question;
import com.axis.sbonline.model.Subject;
import com.axis.sbonline.model.User;
import com.axis.sbonline.model.UserAnswer;
@Repository
public class TestRepoImpl implements TestRepo{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	@Override
	public void createTest(CTest test) {
		em.persist(test);
	}
	@Transactional
	@Override
	public void addResponse(UserAnswer response) {
		em.persist(response);
	}
	@Transactional
	@Override
	public UserAnswer getUserAnswer(int userAnswerId) {
        try {
           String s = "select u from UserAnswer u where u.userAnswerId=:e";
            Query q = em.createQuery(s);
            q.setParameter("e", userAnswerId);
            return (UserAnswer) q.getSingleResult() ;
        }catch (NoResultException no){
        	System.out.println(no.getMessage());
        	return null;
        }
	}

	@Transactional
	@Override
	public Subject getSubject(int subId) {
	    try {
            String s = "select s from Subject s where s.subjectId=:e";
            Query q = em.createQuery(s);
            q.setParameter("e", subId);
            return (Subject) q.getSingleResult() ;
        }catch (NoResultException no){
        	System.out.println(no.getMessage());
        	return null;
        }	// TODO Auto-generated method stub
	}
	@Transactional
	@Override
	public User getUser(int userId) {
	    try {
            String s = "select u from User u where u.id=:e";
            Query q = em.createQuery(s);
            q.setParameter("e", userId);
            return (User) q.getSingleResult() ;
        }catch (NoResultException no){
        	System.out.println(no.getMessage());
        	return null;
        	//throw ResourceNotFoundException("No user found with this user id $userId")
        }
	}
	@Transactional
	@Override
	public CTest getTest(int testId) {
	      try {
	            String s = "select t from CTest t where t.testId=:e";
	            Query q= em.createQuery(s);
	            q.setParameter("e", testId);
	            return (CTest) q.getSingleResult();
	        }catch (NoResultException no){
	        	System.out.println(no.getMessage());
	        	return null;
//	            throw ResourceNotFoundException("No Test Found With this Test Id $testId")
	        }
	  
	}
	@Transactional
	@Override
	public Question getQuestion(int questionId) {
	      try {
	            String s = "select q from Question q where q.questionId=:e";
	            Query q = em.createQuery(s);
	            q.setParameter("e", questionId);
	            return (Question) q.getSingleResult() ; 
	        }catch (NoResultException no){
	        	return null;
//	            throw ResourceNotFoundException("No Question Found with this question Id ")
	        }
	  
	}
	@Transactional
	@Override
	public List<Question> fetchQuestions(int subId, int level) {
	          System.out.println("hello");
	          String s = "select q from Question q where q.subject.subjectId=:e and q.level=:l";
	          Query q = em.createQuery(s);
	          q.setParameter("e", subId);
	          q.setParameter("l", level);
	          if(q.getResultList().isEmpty()) {
	        	  return null;
	          }
	          else {
	        	  return q.getResultList() ;//List<String?>?
	          }
	}

}
