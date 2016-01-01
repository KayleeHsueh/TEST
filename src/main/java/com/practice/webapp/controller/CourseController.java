package com.practice.webapp.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.practice.webapp.dao.CourseDAO;
import com.practice.webapp.entity.Account;
import com.practice.webapp.entity.Course;
import com.practice.webapp.entity.CourseCate;



@Controller
public class CourseController {
	
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/Course", method = RequestMethod.GET)
	public ModelAndView getCourse(@ModelAttribute CourseCate courseCate){
		ModelAndView model = new ModelAndView("Course");
		CourseDAO courseDAO = (CourseDAO)context.getBean("CourseDAO");
		//Course1DAO course1DAO = (Course1DAO)context.getBean("Course1DAO");
		//Course2DAO course2DAO = (Course2DAO)context.getBean("Course2DAO");
		//Course3DAO course3DAO = (Course3DAO)context.getBean("Course3DAO");
		//Course4DAO course4DAO = (Course4DAO)context.getBean("Course4DAO");
		List<Course> courseList = new ArrayList<Course>();
		Account account = (Account)context.getBean("account");
		model.addObject("identity", account.getIdentity());
		System.out.println("Course"+account.getIdentity());
		System.out.println(courseCate.getCourCateId());
		
		if(courseCate.getCourCateId()==801||courseCate.getCourCateId()==0){
			courseCate.setCourCateId(801);
			model.addObject("grade", "大一");
		}else if(courseCate.getCourCateId()==802){
			model.addObject("grade", "大二");
		}else if(courseCate.getCourCateId()==803){
			model.addObject("grade", "大三");
		}else if(courseCate.getCourCateId()==804){
			model.addObject("grade", "大四");
		}
		courseList = courseDAO.getListSem1Obli1(courseCate);
		model.addObject("course11",courseList);
		courseList = courseDAO.getListSem1Obli2(courseCate);
		model.addObject("course12",courseList);
		courseList = courseDAO.getListSem2Obli1(courseCate);
		model.addObject("course21",courseList);
		courseList = courseDAO.getListSem2Obli2(courseCate);
		model.addObject("course22",courseList);
		if(account.getIdentity()!=null){
			if(account.getIdentity().equals("secretary")){
				model = new ModelAndView("redirect:/Comment_Admin");
			}
		}
		return model;
	}
}


