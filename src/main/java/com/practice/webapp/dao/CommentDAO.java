package com.practice.webapp.dao;

import java.util.List;

import com.practice.webapp.entity.Account;
import com.practice.webapp.entity.Comment;
//import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.Professor;
import com.practice.webapp.entity.TeacherHMC;


public interface CommentDAO{	
	
	public void insert(Comment comment, Account account, Professor professor, Course course);//student
	public void delete(Comment comment, Course course);//secretary
	public void update(Comment comment);//student
	public void AddLikes(Comment comment);//student  
	public void stateOK(Comment comment, Account account); 
	public void stateNotOK(Comment comment);
	public List<Comment> getList(Course course);
	public List<Comment> getListOthersComment(Course course);
	public Comment getListMyComment(Course course, Account account);
	public List<Comment> getListSecretaryCheck();
	public List<Comment> getListPassComment();
	public Comment get(Comment comment);
	public List<TeacherHMC> getTeacherList(Course course);
	

}
