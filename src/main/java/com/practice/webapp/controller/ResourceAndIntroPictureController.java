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

import com.practice.webapp.dao.ResourceAndIntroPictureDAO;
import com.practice.webapp.entity.Account;
import com.practice.webapp.entity.ResourceAndIntroPicture;

@Controller
public class ResourceAndIntroPictureController {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/insertRIP", method = RequestMethod.POST)
	public ModelAndView insertRIP(@ModelAttribute ResourceAndIntroPicture resourceandintropicture) {
		ModelAndView model = new ModelAndView("redirect:/IMIntro");
		ResourceAndIntroPictureDAO ResourceAndIntroPictureDAO = (ResourceAndIntroPictureDAO) context.getBean("ResourceAndIntroPictureDAO");
		ResourceAndIntroPictureDAO.insert(resourceandintropicture);
		Account account=(Account)context.getBean("account");
		model.addObject("Login", account);
		return model;
	}

	//@RequestMapping(value = "/updateRIP", method = RequestMethod.POST)
	//public ModelAndView updateRIP(@ModelAttribute ResourceAndIntroPicture resourceandintropicture){
	//	ModelAndView model = new ModelAndView("redirect:/IMIntro");
	//	ResourceAndIntroPictureDAO ResourceAndIntroPictureDAO = (ResourceAndIntroPictureDAO)context.getBean("ResourceAndIntroPictureDAO");
	//	ResourceAndIntroPictureDAO.update(resourceandintropicture);	
	//	return model;
	//}
	
	@RequestMapping(value = "/deleteRIP", method = RequestMethod.POST)
	public ModelAndView deleteRIP(@ModelAttribute ResourceAndIntroPicture resourceandintropicture){
		ModelAndView model = new ModelAndView("redirect:/IMIntro");
		ResourceAndIntroPictureDAO ResourceAndIntroPictureDAO = (ResourceAndIntroPictureDAO)context.getBean("ResourceAndIntroPictureDAO");
		ResourceAndIntroPictureDAO.delete(resourceandintropicture);
		Account account=(Account)context.getBean("account");
		model.addObject("Login", account);
		return model;
	}
	
	@RequestMapping(value = "/IMIntro", method = RequestMethod.GET)
	public ModelAndView getRIPList(){
		
		ModelAndView model = new ModelAndView("IMIntro");
		ResourceAndIntroPictureDAO ResourceAndIntroPictureDAO = (ResourceAndIntroPictureDAO)context.getBean("ResourceAndIntroPictureDAO");
		List<ResourceAndIntroPicture> ResourceAndIntroPictureList = new ArrayList<ResourceAndIntroPicture>();
		ResourceAndIntroPictureList = ResourceAndIntroPictureDAO.getRIPlist();
		model.addObject("picList", ResourceAndIntroPictureList);
		
		return model;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView getHomepageList(){
		
		ModelAndView model = new ModelAndView("index");
		ResourceAndIntroPictureDAO ResourceAndIntroPictureDAO = (ResourceAndIntroPictureDAO)context.getBean("ResourceAndIntroPictureDAO");
		List<ResourceAndIntroPicture> homepagepicList = new ArrayList<ResourceAndIntroPicture>();
		homepagepicList = ResourceAndIntroPictureDAO.getHomepageList();
		model.addObject("homepicList", homepagepicList);
		
		return model;
	}
	
//	@RequestMapping(value = "/HomePage", method = RequestMethod.GET)
//	public ModelAndView getHomepageList_Home(){
//		
//		ModelAndView model = new ModelAndView("HomePage");
//		ResourceAndIntroPictureDAO ResourceAndIntroPictureDAO = (ResourceAndIntroPictureDAO)context.getBean("ResourceAndIntroPictureDAO");
//		List<ResourceAndIntroPicture> homepagepicList = new ArrayList<ResourceAndIntroPicture>();
//		homepagepicList = ResourceAndIntroPictureDAO.getHomepageList();
//		model.addObject("homepicList", homepagepicList);
//		
//		return model;
//	}
}
