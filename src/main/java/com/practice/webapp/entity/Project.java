package com.practice.webapp.entity;

public class Project {
	private int proId;
	private String proAward; 
	private String proIntroduction;
	private String proMember;
	private String proTitle;
	private String proVideo;
	private int proYear;
	private Professor professor = new Professor();
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProAward() {
		return proAward;
	}
	public void setProAward(String proAward) {
		this.proAward = proAward;
	}
	public String getProIntroduction() {
		return proIntroduction;
	}
	public void setProIntroduction(String proIntroduction) {
		this.proIntroduction = proIntroduction;
	}
	public String getProMember() {
		return proMember;
	}
	public void setProMember(String proMember) {
		this.proMember = proMember;
	}
	public String getProTitle() {
		return proTitle;
	}
	public void setProTitle(String proTitle) {
		this.proTitle = proTitle;
	}
	public String getProVideo() {
		return proVideo;
	}
	public void setProVideo(String proVideo) {
		this.proVideo = proVideo;
	}
	public int getProYear() {
		return proYear;
	}
	public void setProYear(int proYear) {
		this.proYear = proYear;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
}
