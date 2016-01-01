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
import com.practice.webapp.dao.CourseDAO;
import com.practice.webapp.entity.Account;
import com.practice.webapp.entity.Comment;
import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.CourseCate;
import com.practice.webapp.entity.Professor;
import com.practice.webapp.entity.TeacherHMC;

@Controller
public class CommentController {
	
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/Comment", method=RequestMethod.GET)
	public ModelAndView getCommentPage(@ModelAttribute Account account,@ModelAttribute Course course){
		ModelAndView model=new ModelAndView("Comment");
		account = (Account)context.getBean("account");
		System.out.println(account.getIdentity()+"HAHAHA");
		if(account.getIdentity()!=null){
			if(account.getIdentity().equals("student")){
				model=new ModelAndView("Comment_act");
			}else if(account.getIdentity().equals("secretary")){
				model=new ModelAndView("Comment_Admin");
			}else if(account.getIdentity().equals("graduate")){
				CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
				CourseDAO courseDAO = (CourseDAO)context.getBean("CourseDAO");
				List<Comment> commentList = new ArrayList<Comment>();
				commentList = commentDAO.getList(course);
				model.addObject("commentList", commentList);
				model.addObject("courName", courseDAO.get(course).getCourName());
				model.addObject("courseBrief",courseDAO.get(course).getCourBriefIntro());
			}
		}else{
			CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
			CourseDAO courseDAO = (CourseDAO)context.getBean("CourseDAO");
			List<Comment> commentList = new ArrayList<Comment>();
			commentList = commentDAO.getList(course);
			model.addObject("commentList", commentList);
			model.addObject("courName", courseDAO.get(course).getCourName());
			model.addObject("courseBrief",courseDAO.get(course).getCourBriefIntro());
		}
		return model;
	}
	
	@RequestMapping(value = "/Comment_act", method=RequestMethod.GET)
	public ModelAndView getComment_actPage(@ModelAttribute Comment comment,@ModelAttribute Course course){
		ModelAndView model=new ModelAndView("Login");
		Account account = (Account)context.getBean("account");
		if(account.getIdentity()!=null){
			if(account.getIdentity().equals("student")){
				model=new ModelAndView("Comment_act");
				CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
				CourseDAO courseDAO = (CourseDAO)context.getBean("CourseDAO");
				
				List<Comment> commentList = new ArrayList<Comment>();
				List<TeacherHMC> teacherList = new ArrayList<TeacherHMC>();
				
				commentList = commentDAO.getListOthersComment(course);
				teacherList=commentDAO.getTeacherList(course);
				
				model.addObject("commentlist", commentList);
				model.addObject("account", account.getUserName());
				model.addObject("courName", courseDAO.get(course).getCourName());
				model.addObject("courId",courseDAO.get(course).getCourId());
				model.addObject("courseBrief",courseDAO.get(course).getCourBriefIntro());
				model.addObject("teacherList",teacherList);
				model.addObject("myList",commentDAO.getListMyComment(course, account));
				//model.addObject("myComContent",commentListMyComment.get(0).getComContent());
				//model.addObject("secrId",commentListMyComment.get(0).getSecretary().getSecreId());
			}
		}
		return model;
	}
	
	@RequestMapping(value = "/LeaveComment", method=RequestMethod.POST)
	public ModelAndView getComment_act(@ModelAttribute Comment comment,@ModelAttribute Course course,@ModelAttribute Professor professor){
		ModelAndView model = new ModelAndView("redirect:/Comment_act?courId="+course.getCourId());
		CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
		Account account = (Account)context.getBean("account");
		
		List<Comment> commentList = new ArrayList<Comment>();
		System.out.println(comment.getComContent()+"Comment>Post");
		commentDAO.insert(comment, account, professor, course);
		commentList = commentDAO.getList(course);
		model.addObject("commenttList", commentList);
		
		
		
		return model;
	}
	
	@RequestMapping(value = "/Comment_Admin", method=RequestMethod.GET)  
	public ModelAndView getComment_Admin(@ModelAttribute Comment comment){
		ModelAndView model=new ModelAndView("Login");
		Account account = (Account)context.getBean("account");
		System.out.println("Comment_Admin");
		if(account.getIdentity()!=null){
			if(account.getIdentity().equals("secretary")){
				model=new ModelAndView("Comment_Admin");
				CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
				List<Comment> commentList = new ArrayList<Comment>();
				commentList = commentDAO.getListSecretaryCheck();
				model.addObject("commentList", commentList);
				commentList = commentDAO.getListPassComment();  ///////Yilin
				model.addObject("commentList2", commentList);  ///////Yilin
				model.addObject("account", account.getId());
			}
		}
		return model;
	}

	
	@RequestMapping(value = "/like", method=RequestMethod.POST)
	public ModelAndView addLike(@ModelAttribute Comment comment, @ModelAttribute Course course){
		ModelAndView model=new ModelAndView("redirect:/Comment_act?courId="+course.getCourId());
		CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
		commentDAO.AddLikes(comment);
		System.out.println("ComId"+comment.getComId());
		System.out.println("AddLikes: "+comment.getAddLikes());
		return model;
	}
	
	@RequestMapping(value = "/StateOK", method=RequestMethod.POST)    ///////Yilin
	public ModelAndView changeState(@ModelAttribute Comment comment){
		ModelAndView model = new ModelAndView("redirect:/Comment_Admin");
		CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
		System.out.println("StateOK");
		Account account=(Account)context.getBean("account");
		commentDAO.stateOK(comment, account);
		return model;
	}
	
	@RequestMapping(value = "/StateNotOK", method=RequestMethod.POST)   ///////Yilin
	public ModelAndView returnComment(@ModelAttribute Comment comment){
		ModelAndView model = new ModelAndView("redirect:/Comment_Admin");
		CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
		System.out.println("StateNotOK");
		commentDAO.stateNotOK(comment);
		
		return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)    ///////Yilin
	public ModelAndView deleteComment(@ModelAttribute Comment comment,@ModelAttribute Course course){
		ModelAndView model = new ModelAndView("redirect:/Comment_Admin");
		CommentDAO commentDAO = (CommentDAO)context.getBean("CommentDAO");
		commentDAO.delete(comment,course);
		System.out.println(course.getCourId());
		return model;
	}

	
}

