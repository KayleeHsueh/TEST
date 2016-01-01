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

import com.practice.webapp.dao.QuestionCategoryDAO;
import com.practice.webapp.dao.QADAO;
import com.practice.webapp.entity.Account;
import com.practice.webapp.entity.QA;
import com.practice.webapp.entity.QuestionCategory;

@Controller
public class QAController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/Q&A", method=RequestMethod.GET)
	public ModelAndView getQA(@ModelAttribute Account account){
		ModelAndView model=new ModelAndView("Q&A");
		account = (Account)context.getBean("account");
		System.out.println(account.getIdentity()+"HAHAHA");
		if(account.getIdentity()!=null/*||account.getIdentity()==""*/){
			if(account.getIdentity().equals("secretary")){
				model=new ModelAndView("Question_ans");
			}else{
				QA qa=(QA)context.getBean("qa");
				QADAO qaDAO = (QADAO)context.getBean("qaDAO");
				List<QA> qaList = new ArrayList<QA>();
				qaList = qaDAO.getProblemSetTrueList();
				model.addObject("qaList", qaList);
			}
		}
		return model;
	}
	
	
	@RequestMapping(value = "/Question", method = RequestMethod.GET)
	public ModelAndView insertQA(){
		ModelAndView model = new ModelAndView("Question");
		QuestionCategoryDAO QuestionCategoryDAO = (QuestionCategoryDAO)context.getBean("QuestionCategoryDAO");
		List<QuestionCategory> QuestionCategoryList = new ArrayList<QuestionCategory>();
		QuestionCategoryList = QuestionCategoryDAO.getList();
		model.addObject("QuestionCategoryList", QuestionCategoryList);
		return model;
	}
	
	@RequestMapping(value = "/Question", method = RequestMethod.POST)
	public ModelAndView insertArticle(@ModelAttribute QA qa){
		ModelAndView model = new ModelAndView("redirect:/Question");
		QADAO qaDAO = (QADAO)context.getBean("qaDAO");
		qaDAO.insert(qa);
		
		return model;
	}
	//常見問題
	@RequestMapping(value = "/QA-a", method = RequestMethod.GET)
	public ModelAndView getProblemSetTrueList(){
		ModelAndView model = new ModelAndView("Q&A");
		QADAO qaDAO = (QADAO)context.getBean("qaDAO");
		List<QA> qaList = new ArrayList<QA>();
		qaList = qaDAO.getProblemSetTrueList();
		model.addObject("usualList", qaList);
		return model;
	}
	//待回答問題
	@RequestMapping(value = "/Question_ans", method = RequestMethod.GET)
	public ModelAndView getTrueList(){
		ModelAndView model = new ModelAndView("Question_ans");
		QADAO qaDAO = (QADAO)context.getBean("qaDAO");
		List<QA> qaList = new ArrayList<QA>();
		qaList = qaDAO.getTrueList();
		model.addObject("waitingList", qaList);
		return model;
	}
	//已回答問題
	@RequestMapping(value = "/Question_ans-2", method = RequestMethod.GET)
	public ModelAndView getFalseList(){
		ModelAndView model = new ModelAndView("Question_ans-2");
		QADAO qaDAO = (QADAO)context.getBean("qaDAO");
		List<QA> qaList = new ArrayList<QA>();
		qaList = qaDAO.getFalseList();
		model.addObject("finList", qaList);
		return model;
	}
	@RequestMapping(value = "/updateQA", method = RequestMethod.GET)
	public ModelAndView updateQAPage(@ModelAttribute QA qa){
		ModelAndView model = new ModelAndView("Question_ans");
		QuestionCategoryDAO QuestionCategoryDAO = (QuestionCategoryDAO)context.getBean("QuestionCategoryDAO");
		QADAO qaDAO = (QADAO)context.getBean("qaDAO");
		List<QuestionCategory> QuestionCategoryList = new ArrayList<QuestionCategory>();
		QuestionCategoryList = QuestionCategoryDAO.getList();
		qa = qaDAO.get(qa);
		model.addObject("QuestionCategoryList", QuestionCategoryList);
		model.addObject("qa", qa);
		return model;
	}
	
	@RequestMapping(value = "/updateQA", method = RequestMethod.POST)
	public ModelAndView updateQA(@ModelAttribute QA qa){
		ModelAndView model = new ModelAndView("redirect:/Question_ans");
		QADAO qaDAO = (QADAO)context.getBean("qaDAO");
		qaDAO.update(qa);
		
		return model;
	}
	
	@RequestMapping(value = "/deleteQA", method = RequestMethod.POST)
	public ModelAndView deleteQA(@ModelAttribute QA qa){
		ModelAndView model = new ModelAndView("redirect:/Question_ans");
		QADAO qaDAO = (QADAO)context.getBean("qaDAO");
		qaDAO.delete(qa);
		
		return model;
	}
}
