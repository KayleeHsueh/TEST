package com.practice.webapp.entity;

//import java.util.Date;

public class CourseHasManyInformation {
	private Course course= new Course();
	private CourseInformation courseInformation= new CourseInformation();
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;		
	}
	
	public CourseInformation getCourseInformation() {
		return courseInformation;
	}
	public void setCourseInformation(CourseInformation courseInformation) {
		this.courseInformation = courseInformation;		
	}
	
}
