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

import com.practice.webapp.dao.ProjectDAO;
import com.practice.webapp.entity.Project;

@Controller
public class ProjectController {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value="/ProjectList", method=RequestMethod.POST)
	public ModelAndView getList(@ModelAttribute Project project){
		
		ModelAndView model = new ModelAndView("redirect:/ProjectList");
		ProjectDAO projectDAO = (ProjectDAO)context.getBean("ProjectDAO");
		List<Project> projectList = new ArrayList<Project>();
		projectList = projectDAO.getList();
		model.addObject("projectList", projectList);
		
		return model;
	}
	
	@RequestMapping(value="/Project", method=RequestMethod.GET)
	public ModelAndView getyearList(){
		
		ModelAndView model = new ModelAndView("Project");
		ProjectDAO projectDAO = (ProjectDAO)context.getBean("ProjectDAO");
		List<Project> yearList = new ArrayList<Project>();
		yearList = projectDAO.getyearList();
		model.addObject("yearList", yearList);
		
		return model;
	}
	
	@RequestMapping(value = "/insertProject", method = RequestMethod.POST)
	public ModelAndView insertproject(@ModelAttribute Project project) {
		ModelAndView model = new ModelAndView("redirect:/Project");
		ProjectDAO projectDAO = (ProjectDAO) context.getBean("ProjectDAO");
		projectDAO.insert(project);

		return model;

	}
//	@RequestMapping(value = "/project", method = RequestMethod.GET)
//	public ModelAndView getPage(@ModelAttribute Project project) {
//		ModelAndView model = new ModelAndView("Project");
//		
//		return model;
//  }

}
