package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Teacher;


public interface TeacherDAO {	
	
	public void insert(Teacher aTeacher);
	public void delete(Teacher aTeacher);
	// public void update(Teacher aTeacher);
	public List<Teacher> getTeacherList();
	public List<Teacher> getSpecialtyList(int profSpeID);
	//public List<Teacher> getReorderList();
	//public List<Teacher> getAvaliableList();
	public Teacher get(Teacher aTeacher);

	

}
