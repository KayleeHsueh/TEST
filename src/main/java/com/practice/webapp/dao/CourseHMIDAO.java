package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.CourseHasManyInformation;


public interface CourseHMIDAO {	
	
	
	public List<CourseHasManyInformation> getList(CourseHasManyInformation courseHMI2);
	public CourseHasManyInformation get(CourseHasManyInformation courseHasManyInformation);
	

}
