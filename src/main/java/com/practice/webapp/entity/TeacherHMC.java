package com.practice.webapp.entity;

public class TeacherHMC {
	private Course course=new Course();
	private Professor professor=new Professor();
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor =professor;
	}
}
