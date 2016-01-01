package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.CourseCate;

public interface Course1SignInDAO {//��敺� 蝟餃����憓���
	public void insert(Course Course1);
	public void delete(Course Course1);
	public Course get1(Course Course111);//211== 鈭僑蝝���耨
	public List<Course> getList111();
	public Course get2(Course Course112);//212==鈭僑蝝��靽�
	public List<Course> getList112();
	public Course get3(Course Course121);//221==鈭僑蝝���耨
	public List<Course> getList121();
	public Course get4(Course Course122);//222==鈭僑蝝��靽�
	public List<Course> getList122();
	public CourseCate getCourseCate(CourseCate CourseCate);//CourseCate==撟渡��
	public List<CourseCate> getListCate();
}
