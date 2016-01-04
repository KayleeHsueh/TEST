package com.practice.webapp.entity;

import java.util.Date;

public class Comment {
	private int comId;
	private Course course = new Course();
	private Student student = new Student();
	
	//private String title;
	private String comContent;
	private Professor professor=new Professor();
	private int comLikes;
	private int courStars;
	private boolean comState=false;
	//private Date createDate;
	private Date comUploadDate;
	private Secretary secretary=new Secretary();
	
	public int getComId() {
		return comId;
	}
	public void setComId(int comId) {
		this.comId = comId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;		
	}	
	
	
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;		
	}
	public int getCourStars() {
		return courStars;
	}
	public void setCourStars(int courStars) {
		this.courStars = courStars;
	}
	public int getComLikes() {
		return comLikes;
	}
	public void setComLikes(int comLikes) {
		this.comLikes = comLikes;
	}
	public int getAddLikes() {
		return comLikes;
	}
	public void setAddLikes(int comLikes) {
		this.comLikes = comLikes+1;
	}
	public boolean getComState() {
		return comState;
	}
	public void setComState(boolean comState) {
		if(comState==true){
			this.comState = comState;
		}
	}
//	public Date getCreateDate() {
//		return createDate;
//	}
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
	public Date getComUploadDate() {
		return comUploadDate;
	}
	public void setComUploadDate(Date comUploadDate) {
		this.comUploadDate = comUploadDate;
	}
		
	public Secretary getSecretary() {
		return secretary;
	}
	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;		
	}
}
