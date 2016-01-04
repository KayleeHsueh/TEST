package com.practice.webapp.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.Course1DAO;
import com.practice.webapp.entity.Course;



@Controller
public class CourseController {
	
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/Course", method = RequestMethod.GET)
	public ModelAndView getCourse(){
		ModelAndView model = new ModelAndView("Course");
		Course1DAO course1DAO = (Course1DAO)context.getBean("Course1DAO");
		List<Course> course111List = new ArrayList<Course>();
		course111List = course1DAO.getList111();
		model.addObject("course111", course111List);
		return model;
	}
	
}


