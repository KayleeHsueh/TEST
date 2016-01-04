package com.practice.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.AccountDAO;
import com.practice.webapp.dao.CommentDAO;
import com.practice.webapp.entity.Account;
import com.practice.webapp.entity.Comment;
import com.practice.webapp.entity.Product;


@Controller
public class CommentController {
	
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/Comment", method=RequestMethod.GET)
	public ModelAndView getCommentPage(@ModelAttribute Account account){
		ModelAndView model=new ModelAndView("Comment");
		account = (Account)context.getBean("account");
		System.out.println(account.getIdentity()+"HAHAHA");
		if(account.getIdentity()!=null/*||account.getIdentity()==""*/){
			if(account.getIdentity().equals("student")){
				model=new ModelAndView("Comment_act");
			}else if(account.getIdentity().equals("secretary")){
				model=new ModelAndView("Comment_Admin");
			}else{
				Comment comment=(Comment)context.getBean("comment");
				CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
				List<Comment> commentList = new ArrayList<Comment>();
				commentList = commentDAO.getList(comment);
				model.addObject("commentList", commentList);
			}
		}
		return model;
	}
	
	@RequestMapping(value = "/Comment_act", method=RequestMethod.GET)
	public ModelAndView getComment_actPage(@ModelAttribute Comment comment){
		ModelAndView model=new ModelAndView("Login");
		Account account = (Account)context.getBean("account");
		//System.out.println(account.getIdentity());
		if(account.getIdentity()!=null/*||account.getIdentity()==""*/){
			if(account.getIdentity().equals("student")){
				model=new ModelAndView("Comment_act");
				CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
				List<Comment> commentList = new ArrayList<Comment>();
				commentList = commentDAO.getList(comment);
				model.addObject("commenttList", commentList);
			}
		}
		return model;
	}
	
	@RequestMapping(value = "/LeaveComment", method=RequestMethod.POST)
	public ModelAndView getComment_act(@ModelAttribute Comment comment){
		ModelAndView model = new ModelAndView("redirect:/Comment_act");
		CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
		System.out.println(comment.getComContent()+"Comment>Post");
		commentDAO.insert(comment);
		List<Comment> commentList = new ArrayList<Comment>();
		commentList = commentDAO.getListMyComment(comment);
		model.addObject("commenttList", commentList);
		return model;
	}
	
	@RequestMapping(value = "/Comment_Admin", method=RequestMethod.GET)
	public ModelAndView getComment_Admin(@ModelAttribute Comment comment){
		ModelAndView model=new ModelAndView("Login");
		Account account = (Account)context.getBean("account");
		if(account.getIdentity()!=null){
			if(account.getIdentity().equals("secretary")){
				model=new ModelAndView("Comment_Admin");
				CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
				List<Comment> commentList = new ArrayList<Comment>();
				commentList = commentDAO.getListSecretaryCheck(comment);
				model.addObject("commentList", commentList);
			}
		}
		return model;
	}
	
	@RequestMapping(value = "/Like", method=RequestMethod.POST)
	public ModelAndView addLike(@ModelAttribute Comment comment){
		ModelAndView model=new ModelAndView("Comment_act");
		CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
		commentDAO.AddLikes(comment);		
		return model;
	}
	
}

