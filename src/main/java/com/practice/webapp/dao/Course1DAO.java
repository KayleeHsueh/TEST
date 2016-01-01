package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.CourseCate;

public interface Course1DAO {//憭找�隤脩���� 
	public Course get1(Course Course111);//111==銝�撟渡��銝�耨
	public List<Course> getList111();
	public Course get2(Course Course112);//112==銝�撟渡��銝靽�
	public List<Course> getList112();
	public Course get3(Course Course121);//121==銝�撟渡��銝�耨
	public List<Course> getList121();
	public Course get4(Course Course122);//122==銝�撟渡��銝靽�
	public List<Course> getList122();
	public Course get(Course CourBriefIntro);//隤脩�陛隞�
	public List<Course> getListCourBriefIntro();
	public CourseCate getCourseCate(CourseCate CourseCate);//CourseCate==隤脩�僑蝝�
//public List<CourseCate> getListCate();
}
