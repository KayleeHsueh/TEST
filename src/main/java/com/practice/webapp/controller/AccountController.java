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
			if(accountDAO.checkLoginStudent(account.getUsername(), account.getPassword())==true){
				Account account_session = (Account)context.getBean("account");
				account_session.setUsername(account.getUsername());
				account_session.setPassword(account.getPassword());
				account_session.setIdentity(account.getIdentity());
				account_session.setIsLogin(true);
				model.addObject("Login", account_session);
			    //System.out.println(account.getIdentity());
				System.out.println("Successful!");
				System.out.println(account_session.getIdentity());
				model = new ModelAndView("redirect:/Comment_act");
			}
		}else if(account.getIdentity().equals("secretary")){
			if(accountDAO.checkLoginSecretary(account.getUsername(), account.getPassword())==true){
				Account account_session = (Account)context.getBean("account");
				account_session.setUsername(account.getUsername());
				account_session.setPassword(account.getPassword());
				account_session.setIdentity(account.getIdentity());
				account_session.setIsLogin(true);
				
				model.addObject("Login", account_session);
				model = new ModelAndView("redirect:/Comment_Admin");
				
				System.out.println(account_session.getIdentity());
			}
		}else{
			model = new ModelAndView("Login");
			Account account_session = (Account)context.getBean("account");
			account_session.setUsername(null);
			account_session.setPassword(null);
			account_session.setIdentity(null);
			account_session.setClassName(null);
			account_session.setSchoolID(null);
			account_session.setIsLogin(false);
			System.out.println("failed!");
			
		}
		return model;
	}
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("index");
		Account account= (Account)context.getBean("account");
		System.out.println("GET");
		if(account.getIdentity()==null){
			model=new ModelAndView("Login");
			System.out.print("Login");
			
		}else{
			
			System.out.print("Identity BEFORE logging out and cleaning the session :");
			System.out.println(account.getIdentity());
			System.out.println(account.getIsLogin());
			
			account.setUsername(null);
			account.setPassword(null);
			account.setIdentity(null);
			account.setClassName(null);
			account.setSchoolID(null);
			account.setIsLogin(false);
			
			System.out.print("Identity AFTER logging out and cleaning the session :");
			System.out.println(account.getUsername());
			System.out.println(account.getIsLogin());
			
			model.addObject("Login", account.getIsLogin());
		}
		return model;
	}
	
}
