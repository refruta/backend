package com.axis.sbonline.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.axis.sbonline.model.Question;
import com.axis.sbonline.model.Subject;

@Repository
public class AdminRepoImpl implements AdminRepo{

	@PersistenceContext
	private EntityManager entityManager;
	@Transactional
	@Override
	public void addSub(Subject sub) {
			entityManager.persist(sub);
	}
	@Transactional
	@Override
	public Subject getSubject(int subId) {
	     try {   
			String s="select s from Subject s where s.subjectId=:e";
	        Query q = entityManager.createQuery(s);
	        q.setParameter("e",subId);
	        return (Subject) q.getSingleResult();
	     }catch (NoResultException no) {
	    	 System.out.println(no.getMessage());
	    	 return null;
	     }
	}

	@Transactional
	@Override
	public void addQuestion(Question question) {
			entityManager.persist(question);
	}

	@Transactional
	@Override
	public List<Question> fetchQuestions(int subId) {
		System.out.println("hello");
		try{
			String s = "select q from Question q where q.subject.subjectId=:e";
		Query q = entityManager.createQuery(s);
		q.setParameter("e", subId);
		List<Question> list = q.getResultList();
		return list;
		}catch (NoResultException no) {
			System.out.println(no.getMessage());
			return null;
		}
	}
	@Transactional
	@Override
	public void deleteQuestion(int quesId) {
		String s = "delete from Question q where q.questionId=:e";
		Query q = entityManager.createQuery(s);
		q.setParameter("e", quesId);
		q.executeUpdate();
	}

}
