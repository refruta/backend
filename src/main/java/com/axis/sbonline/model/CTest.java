package com.axis.sbonline.model;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="table_test")
public class CTest {

	@Id
	@GeneratedValue	(strategy = GenerationType.IDENTITY)
	@Column(name="test_id")
	private int testId;
	
	@Column(name="test_level")
	private int level;
	
	@Column(name="date_and_time_of_test")
	private LocalDateTime dateAndTimeOfTest;
	
	@JoinColumn(name="user_id")
	@ManyToOne
	@JsonIgnore
	private User user;

	@JoinColumn(name="subject_id")
	@OneToOne
	@JsonIgnore
	private Subject subject;
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public LocalDateTime getDateAndTimeOfTest() {
		return dateAndTimeOfTest;
	}

	public void setDateAndTimeOfTest(LocalDateTime dateAndTimeOfTest) {
		this.dateAndTimeOfTest = dateAndTimeOfTest;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
