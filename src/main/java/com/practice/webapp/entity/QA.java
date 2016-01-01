package com.practice.webapp.entity;

import java.net.PasswordAuthentication;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.util.Date;

public class QA {
	private int Question_ID;
	private String Question_Content;
	private String Asker_Name;
	private String Asker_Email;
	private String Answer_Content;
	private boolean ProblemSet;
	private Date Upload_Date;
	private QuestionCategory questioncategory = new QuestionCategory();
	
	
	public int getQuestion_ID() {
		return Question_ID;
	}
	public void setQuestion_ID(int Question_ID) {
		this.Question_ID = Question_ID;
	}
	public String getAsker_Name() {
		return Asker_Name;
	}
	public void setAsker_Name(String Asker_Name) {
		this.Asker_Name = Asker_Name;
	}
	public String getAsker_Email() {
		return Asker_Email;
	}
	public void setAsker_Email(String Asker_Email) {
		this.Asker_Email = Asker_Email;
	}
	public String getQuestion_Content() {
		return Question_Content;
	}
	public void setQuestion_Content(String Question_Content) {
		this.Question_Content = Question_Content;
	}
	public String getAnswer_Content() {
		return Answer_Content;
	}
	public void setAnswer_Content(String Answer_Content) {
		this.Answer_Content = Answer_Content;
	}
	public Date getUpload_Date() {
		return 	Upload_Date;
	}
	public void setUpload_Date(Date Upload_Date) {
		this.Upload_Date = Upload_Date;
	}
	public QuestionCategory getQuestionCategory() {
		return questioncategory;
	}
	public void setQuestionCategory(QuestionCategory questioncategory) {
		this.questioncategory = questioncategory;
	}	
	public boolean getProblemSet() {
		return ProblemSet;
	}
	public void setProblemSet(boolean ProblemSet) {
		this.ProblemSet = ProblemSet;
	}
	
}
