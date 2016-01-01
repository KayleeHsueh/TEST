package com.practice.webapp.dao;


import java.util.List;

import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.CourseCate;

public interface Course4DAO {//憭批�玨蝔���
	public Course get1(Course Course411);//411==��僑蝝���耨
	public List<Course> getList411();
	public Course get2(Course Course412);//412==��僑蝝��靽�
	public List<Course> getList412();
	public Course get3(Course Course421);//421==��僑蝝���耨
	public List<Course> getList421();
	public Course get4(Course Course422);//422==��僑蝝��靽�
	public List<Course> getList422();
	public CourseCate getCourseCate(CourseCate CourseCate);//CourseCate==撟渡��
	public List<CourseCate> getListCate();
	public Course get(Course CourBriefIntro);//隤脩�陛隞�
	public List<Course> getListCourBriefIntro();
}
