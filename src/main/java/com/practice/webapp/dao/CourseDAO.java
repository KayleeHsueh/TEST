package com.practice.webapp.dao;

import java.util.List;


import com.practice.webapp.entity.Course;
//import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.CourseCate;


public interface CourseDAO{	
	
	public void insert(Course course);
	public void newSem1Obl1(Course course);//新增上學期必修的按鍵
	public void newSem2Obl1(Course course);//新增下學期必修的按鍵
	public void delete(Course course);
	
	public List<Course> getListSem1Obli1(CourseCate courseCate);
	public List<Course> getListSem1Obli2(CourseCate courseCate);
	public List<Course> getListSem2Obli1(CourseCate courseCate);
	public List<Course> getListSem2Obli2(CourseCate courseCate); 
	public Course get(Course course);
	

}
