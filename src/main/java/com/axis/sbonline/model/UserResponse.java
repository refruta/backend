package com.axis.sbonline.model;

public class UserResponse {

	private String optionChosen;
	private int marksObtained;
	private int questionId;
	private int testId;
	private int uid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
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
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	
	
}
