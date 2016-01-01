package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.CourseCate;

public interface Course4SignInDAO {//��敺� 蝟餃����憓���
	public void insert(Course Course1);
	public void delete(Course Course1);
	public Course get1(Course Course411);//111==銝�撟渡��銝�耨
	public List<Course> getList411();
	public Course get2(Course Course412);//112==銝�撟渡��銝靽�
	public List<Course> getList412();
	public Course get3(Course Course421);//121==銝�撟渡��銝�耨
	public List<Course> getList421();
	public Course get4(Course Course422);//122==銝�撟渡��銝靽�
	public List<Course> getList422();
	public CourseCate getCourseCate(CourseCate CourseCate);//CourseCate==撟渡��
	public List<CourseCate> getListCate();
}
