package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Project;

public interface ProjectDAO {

	public void insert(Project project);
	public void delete(Project project);
	public void update(Project project);
	public List<Project> getList();
	public List<Project> getyearList();
}
