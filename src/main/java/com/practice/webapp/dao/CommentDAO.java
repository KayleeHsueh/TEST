package com.practice.webapp.dao;

import java.util.List;


import com.practice.webapp.entity.Comment;
//import com.practice.webapp.entity.Course;


public interface CommentDAO{	
	
	public void insert(Comment comment);//student
	public void delete(Comment comment);//secretary
	public void update(Comment comment);//student
	public void AddLikes(Comment comment);//student  
	public void stateOK(Comment comment); 
	public void stateNotOK(Comment comment);
	public List<Comment> getList(Comment comment);
	public List<Comment> getListOthersComment(Comment comment);
	public List<Comment> getListMyComment(Comment comment);
	public List<Comment> getListSecretaryCheck(Comment comment);
	public List<Comment> getListPassComment(Comment comment);
	public Comment get(Comment comment);
	

}
