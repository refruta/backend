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
@Table(name="table_report")
public class Report {

	@Id
	@Column(name="report_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportId;

	@Column(name="test_score")
	private int testScore;
	
	@Column(name="total_score")
	private int totalScore;
	
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Column(name="cleared_level")
	private int clearedLevel;
	
	@JoinColumn(name="user_id")
	@OneToOne
	@JsonIgnore
	private User user;
	
	@JoinColumn(name="test_id")
	@OneToOne
	@JsonIgnore
	private CTest test;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getTestScore() {
		return testScore;
	}

	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}

	public int getClearedLevel() {
		return clearedLevel;
	}

	public void setClearedLevel(int clearedLevel) {
		this.clearedLevel = clearedLevel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CTest getTest() {
		return test;
	}

	public void setTest(CTest test) {
		this.test = test;
	}
}
