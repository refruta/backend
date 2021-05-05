package com.axis.sbonline.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.axis.sbonline.model.Report;

@Repository
public class GenerateRepoImpl implements GenerateRepo {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public List<Integer> getMarksById(int id) {
	
			Query q =  em.createQuery("select u.marksObtained from UserAnswer u where u.uid=:i");
	    q.setParameter("i", id);
	    if(q.getResultList().isEmpty()) {
	    	return null;
	    }else {
	    	return q.getResultList();
	    }
	}
	
	@Transactional
	@Override
	public void addReport(Report repo) {
		em.persist(repo);
	}
	@Transactional
	@Override
	public Report getReport(int reportId) {
		try {
	     Query q = em.createQuery("select r from Report r where r.reportId=:i");
	    	   q.setParameter("i",reportId);
	    	   return (Report) q.getSingleResult() ;
		}catch (NoResultException no) {
			System.out.println(no.getMessage());
			return null;
		}
	}
	@Transactional
	@Override
	public List<Report> getAllReportsByUser(int userId) {
	     Query q= em.createQuery("select r from Report r where r.user.id =: userId");
	    	       q.setParameter("userId", userId);
	    	      if(q.getResultList().isEmpty()) {
	    	    	  return null;
	    	      	}
	    	      else {
	    	    	  return q.getResultList();
	    	      }
	}
}
