package com.practice.webapp.entity;

//import java.util.Date;

public class Course {
	private int courId;
	private String courName;
	private CourseCate courseCate=new CourseCate();
	private int courStars;
	private String courObligatory;
	private String courBlockCourID;
	private String courBriefIntro;
	//private ArticleCategory articleCategory = new ArticleCategory();
	public int getCourId() {
		return courId;
	}
	public void setCourId(int courId) {
		this.courId = courId;
	}
	public String getCourName() {
		return courName;
	}
	public void setCourName(String courName) {
		this.courName = courName;
	}
	public CourseCate getCourseCate() {
		return courseCate;
	}
	public void setCourseCate(CourseCate courseCate) {
		this.courseCate = courseCate;
	}
	public int getCourStars() {
		return courStars;
	}
	public void setCourStars(int courStars) {
		this.courStars = courStars;
	}
	public String getCourObligatory() {
		return courObligatory;
	}
	public void setCourObligatory(String courObligatory) {
		this.courObligatory = courObligatory;
	}
	public String getCourBlockCourID() {
		return courBlockCourID;
	}
	public void setCourBlockCourID(String courBlockCourID) {
		this.courBlockCourID = courBlockCourID;
	}
	public String getCourBriefIntro() {
		return courBriefIntro;
	}
	public void setCourBriefIntro(String courBriefIntro) {
		this.courBriefIntro = courBriefIntro;
	}	
}
