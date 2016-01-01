package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.QA;


public interface QADAO {	
	
	public void insert(QA qa);
	public void delete(QA qa);
	public void update(QA qa);
	public List<QA> getProblemSetTrueList();
	public List<QA> getProblemSetFalseList();
	public List<QA> getTrueList();
	public List<QA> getFalseList();
	public QA get(QA qa);
	

}
