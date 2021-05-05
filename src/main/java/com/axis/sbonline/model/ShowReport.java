package com.axis.sbonline.model;

import java.time.LocalDateTime;

public class ShowReport {
    private String name;
    private String email ;
    private LocalDateTime dateAndTimeOfTest ;
    private int level = 0;
    private String subjecName;
    private int testScore = 0;
    private int totalScore = 0;
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "ShowReport [name=" + name + ", email=" + email + ", dateAndTimeOfTest="
				+ dateAndTimeOfTest + ", Cleared Level=" + level + ", subjecName=" + subjecName + ", testScore=" + testScore
				+ ", totalScore=" + totalScore + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDateTime getDateAndTimeOfTest() {
		return dateAndTimeOfTest;
	}
	public void setDateAndTimeOfTest(LocalDateTime dateAndTimeOfTest) {
		this.dateAndTimeOfTest = dateAndTimeOfTest;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getSubjecName() {
		return subjecName;
	}
	public void setSubjecName(String subjecName) {
		this.subjecName = subjecName;
	}
	public int getTestScore() {
		return testScore;
	}
	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
}
