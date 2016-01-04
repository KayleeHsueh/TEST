package com.practice.webapp.entity;


import java.util.Date;

public class QA {
	private int question_ID;
	private String question_Content;
	private String asker_Name;
	private String asker_Email;
	private String answer_Content;
	private boolean problemSet;
	private Date upload_Date;
	private QuestionCategory questionCategory = new QuestionCategory();
	
	
	
	
	public QuestionCategory getQuestionCategory() {
		return questionCategory;
	}
	public void setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;

	
	}
	public int getQuestion_ID() {
		return question_ID;
	}
	public void setQuestion_ID(int question_ID) {
		this.question_ID = question_ID;
	}
	public String getQuestion_Content() {
		return question_Content;
	}
	public void setQuestion_Content(String question_Content) {
		this.question_Content = question_Content;
	}
	public String getAsker_Name() {
		return asker_Name;
	}
	public void setAsker_Name(String asker_Name) {
		this.asker_Name = asker_Name;
	}
	public String getAsker_Email() {
		return asker_Email;
	}
	public void setAsker_Email(String asker_Email) {
		this.asker_Email = asker_Email;
	}
	public String getAnswer_Content() {
		return answer_Content;
	}
	public void setAnswer_Content(String answer_Content) {
		this.answer_Content = answer_Content;
	}
	public boolean isProblemSet() {
		return problemSet;
	}
	public void setProblemSet(boolean problemSet) {
		this.problemSet = problemSet;
	}
	public Date getUpload_Date() {
		return upload_Date;
	}
	public void setUpload_Date(Date upload_Date) {
		this.upload_Date = upload_Date;
	}
}
