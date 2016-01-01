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
import com.practice.webapp.dao.GraduateDAO;
import com.practice.webapp.entity.Account;
import com.practice.webapp.entity.Graduate;
import com.practice.webapp.entity.SuggestionFromGradu;


@Controller
public class SugFromGradController {
	
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/GraduateSug", method=RequestMethod.GET)
	public ModelAndView getSugPage(@ModelAttribute Account account){
		ModelAndView model=new ModelAndView("GraduateSug");
		account = (Account)context.getBean("account");
		System.out.println(account.getIdentity()+"HAHAHA");
		if(account.getIdentity()!=null){
			if(account.getIdentity().equals("graduate")){
				model=new ModelAndView("Suggest");
			}else if(account.getIdentity().equals("secretary")){
				model=new ModelAndView("Suggest_Admin");
			}
		}else{
			GraduateDAO gradDAO = (GraduateDAO)context.getBean("GraduateDAO");
			
			List<SuggestionFromGradu> sugList = new ArrayList<SuggestionFromGradu>();
			sugList = gradDAO.getList();
			model.addObject("sugList", sugList);
			//model.addObject("courName", courseDAO.get(course).getCourName());
			//model.addObject("courseBrief",courseDAO.get(course).getCourBriefIntro());
	
		}
		return model;
	}
	
	@RequestMapping(value = "/Suggest", method=RequestMethod.GET) //_act
	public ModelAndView getSug_actPage(@ModelAttribute SuggestionFromGradu suggestionFG){
		ModelAndView model=new ModelAndView("Login");
		Account account = (Account)context.getBean("account");
		//System.out.println(account.getIdentity());
		if(account.getIdentity()!=null){
			if(account.getIdentity().equals("graduate")){
				model=new ModelAndView("Suggest");
				GraduateDAO gradDAO = (GraduateDAO)context.getBean("GraduateDAO");		
				List<SuggestionFromGradu> sugList = new ArrayList<SuggestionFromGradu>();			
				sugList = gradDAO.getMyList(suggestionFG, account);			
				
				model.addObject("sugList", sugList);				
			}
		}
		return model;
	}
	
	@RequestMapping(value = "/LeaveSug", method=RequestMethod.POST)
	public ModelAndView leaveSug_act(@ModelAttribute SuggestionFromGradu sugFG ,@ModelAttribute Graduate graduate){
		ModelAndView model = new ModelAndView("redirect:/Sug_act?gradId="+graduate.getGradId());
		GraduateDAO sugDAO = (GraduateDAO)context.getBean("GraduateDAO");
		Account account = (Account)context.getBean("account");
		
		List<SuggestionFromGradu> sugList = new ArrayList<SuggestionFromGradu>();
		System.out.println(sugFG.getSugWorkSharing()+"Comment>Post");
		sugDAO.insert(sugFG , account);
		sugList = sugDAO.getList();
		model.addObject("commentList", sugList);
		
		
		
		return model;
	}
	
	@RequestMapping(value = "/Suggest_Admin", method=RequestMethod.GET)  
	public ModelAndView getComment_Admin(){
		ModelAndView model=new ModelAndView("Login");
		Account account = (Account)context.getBean("account");
		System.out.println("Suggest_Admin");
		if(account.getIdentity()!=null){
			if(account.getIdentity().equals("secretary")){
				model=new ModelAndView("Suggest_Admin");
				GraduateDAO gradDAO = (GraduateDAO)context.getBean("GraduateDAO");
				List<SuggestionFromGradu> checkSugList = new ArrayList<SuggestionFromGradu>();
				checkSugList = gradDAO.getListSecretaryCheck();
				model.addObject("checkSugList", checkSugList);
				checkSugList = gradDAO.getList();  ///////Yilin
				model.addObject("checkSugList2", checkSugList);  ///////Yilin
				model.addObject("account", account.getId());
			}
		}
		return model;
	}

	
	
	
//	@RequestMapping(value = "/StateOK", method=RequestMethod.POST)    ///////Yilin
//	public ModelAndView changeState(@ModelAttribute SuggestionFromGradu sugFG){
//		ModelAndView model = new ModelAndView("redirect:/Sug_Admin");
//		GraduateDAO gradDAO = (GraduateDAO)context.getBean("GraduateDAO");
//		System.out.println("StateOK");
//		Account account=(Account)context.getBean("account");
//		gradDAO.stateOK(sugFG, account);
//		return model;
//	}
//	
//	
//	
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)    ///////Yilin
//	public ModelAndView deleteSug(@ModelAttribute SuggestionFromGradu sugFG){
//		ModelAndView model = new ModelAndView("redirect:/Sug_Admin");
//		GraduateDAO gradDAO = (GraduateDAO)context.getBean("GraduateDAO");
//		gradDAO.delete(sugFG);
//		//System.out.println(course.getCourId());
//		return model;
//	}

	
}

