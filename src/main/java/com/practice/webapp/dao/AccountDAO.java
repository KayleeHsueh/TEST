package com.practice.webapp.dao;

import com.practice.webapp.entity.Account;

public interface AccountDAO {
	public boolean checkLoginStudent(int id, String password);
	public boolean checkLoginSecretary(int id, String password);
	public boolean checkLoginGraduate(int id, String password);
	public Account getStudent(Account account);
	public Account getGraduate(Account account);

}
