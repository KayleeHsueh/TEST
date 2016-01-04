package com.practice.webapp.dao;

public interface AccountDAO {
	public boolean checkLoginStudent(String name, String password);
	public boolean checkLoginSecretary(String name, String password);

}
