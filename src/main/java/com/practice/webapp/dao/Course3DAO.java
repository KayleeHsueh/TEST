package com.practice.webapp.dao;


import java.util.List;

import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.CourseCate;

public interface Course3DAO {//憭找�玨蝔���
	public Course get1(Course Course311);//311==銝僑蝝���耨
	public List<Course> getList311();
	public Course get2(Course Course312);//312==銝僑蝝��靽�
	public List<Course> getList312();
	public Course get3(Course Course321);//321==銝僑蝝���耨
	public List<Course> getList321();
	public Course get4(Course Course322);//322==銝僑蝝��靽�
	public List<Course> getList322();
	public CourseCate getCourseCate(CourseCate CourseCate);//CourseCate==撟渡��
	public List<CourseCate> getListCate();
	public Course get(Course CourBriefIntro);//隤脩�陛隞�
	public List<Course> getListCourBriefIntro();
}
