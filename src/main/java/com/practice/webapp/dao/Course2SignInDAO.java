package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.CourseCate;

public interface Course2SignInDAO {//��敺� 蝟餃����憓���
	public void insert(Course Course2);
	public void delete(Course Course2);
	public Course get1(Course Course211);//211==鈭僑蝝���耨
	public List<Course> getList211();
	public Course get2(Course Course212);//212==鈭僑蝝��靽�
	public List<Course> getList212();
	public Course get3(Course Course221);//221==鈭僑蝝���耨
	public List<Course> getList221();
	public Course get4(Course Course222);//222==鈭僑蝝��靽�
	public List<Course> getList222();
	public CourseCate getCourseCate(CourseCate CourseCate);//CourseCate==撟渡��
	public List<CourseCate> getListCate();
}
