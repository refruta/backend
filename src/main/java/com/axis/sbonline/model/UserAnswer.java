package com.axis.sbonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="table_user_answer")
public class UserAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_answer_id")
	private int userAnswerId;
	
	@Column(name="option_chosen")
	private String optionChosen;
	
	@Column(name="marks_obtained")
	private int marksObtained;

	
	@Column(name="user_id")
	private int uid;

	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUserAnswerId() {
		return userAnswerId;
	}

	public void setUserAnswerId(int userAnswerId) {
		this.userAnswerId = userAnswerId;
	}

	@JoinColumn(name="question_id")
	@OneToOne
	@JsonIgnore
	private Question question;
	
	public CTest getTest() {
		return test;
	}

	public void setTest(CTest test) {
		this.test = test;
	}

	@JoinColumn(name="test_id")
	@OneToOne
	@JsonIgnore
	private CTest test;

	
	public String getOptionChosen() {
		return optionChosen;
	}

	public void setOptionChosen(String optionChosen) {
		this.optionChosen = optionChosen;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
