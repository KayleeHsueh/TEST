package com.practice.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.webapp.dao.AccountDAO;
import com.practice.webapp.entity.Account;

@Controller
public class AccountController {
	
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute Account account) {
		ModelAndView model = new ModelAndView();
		AccountDAO accountDAO = (AccountDAO)context.getBean("AccountDAO");
		System.out.println("POST");
		
		if(account.getIdentity().equals("student")){
			if(accountDAO.checkLoginStudent(account.getId(), account.getPassword())==true){
				Account account_session = (Account)context.getBean("account");
				account_session.setId(account.getId());
				account_session.setPassword(account.getPassword());
				account_session.setIdentity(account.getIdentity());
				account_session.setIsLogin(true);
				account_session.setClassName(accountDAO.getStudent(account).getclassName());
				account_session.setUserName(accountDAO.getStudent(account).getUserName());
				model.addObject("Login", account_session);
			    //System.out.println(account.getIdentity());
				System.out.println("Successful!");
				System.out.println(account_session.getIdentity());
				model = new ModelAndView("redirect:/HomePage");
			}
		}else if(account.getIdentity().equals("secretary")){
			if(accountDAO.checkLoginSecretary(account.getId(), account.getPassword())==true){
				Account account_session = (Account)context.getBean("account");
				account_session.setId(account.getId());
				account_session.setPassword(account.getPassword());
				account_session.setIdentity(account.getIdentity());
				account_session.setIsLogin(true);
				model.addObject("Login", account_session);
				model = new ModelAndView("redirect:/HomePage");
				
				System.out.println(account_session.getIdentity());
			}
		}else if(account.getIdentity().equals("graduate")){
			if(accountDAO.checkLoginGraduate(account.getId(), account.getPassword())==true){
				Account account_session = (Account)context.getBean("account");
				account_session.setId(account.getId());
				account_session.setPassword(account.getPassword());
				account_session.setIdentity(account.getIdentity());
				account_session.setCompanyName(accountDAO.getGraduate(account).getCompanyName());
				account_session.setPosition(accountDAO.getGraduate(account).getPosition());
				account_session.setPicture(accountDAO.getGraduate(account).getPicture());
				account_session.setIsLogin(true);
				model.addObject("Login", account_session);
				model = new ModelAndView("redirect:/HomePage");
				
				System.out.println(account_session.getIdentity());
			}
		}else{
			model = new ModelAndView("Login");
			Account account_session = (Account)context.getBean("account");
			account_session.setUserName(null);
			account_session.setPassword(null);
			account_session.setIdentity(null);
			account_session.setClassName(null);
			account_session.setId(0);
			account_session.setIsLogin(false);
			System.out.println("failed!");
			
		}
		return model;
	}
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("HomePage");
		Account account= (Account)context.getBean("account");
		System.out.println("GET");
		if(account.getIdentity()==null){
			model=new ModelAndView("Login");
			System.out.print("Login");
			
		}else{
			
			System.out.print("Identity BEFORE logging out and cleaning the session :");
			System.out.println(account.getIdentity());
			System.out.println(account.getIsLogin());
			
			account.setUserName(null);
			account.setPassword(null);
			account.setIdentity(null);
			account.setClassName(null);
			account.setId(0);
			account.setIsLogin(false);
			
			System.out.print("Identity AFTER logging out and cleaning the session :");
			System.out.println(account.getId());
			System.out.println(account.getIsLogin());
			
			model.addObject("Login", account.getIsLogin());
		}
		return model;
	}
	@RequestMapping(value = "/HomePage", method = RequestMethod.GET)
	public ModelAndView indexPage() {
		ModelAndView model = new ModelAndView("HomePage");
		Account account= (Account)context.getBean("account");
		System.out.println("GET hahaha");
		model.addObject("Login", account.getIsLogin());
		return model;
	}
}
