package com.practice.webapp.controller;

import java.util.ArrayList;
import java.util.List;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




import com.practice.webapp.dao.TeacherDAO;
import com.practice.webapp.entity.Teacher;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TeacherController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
/*	@RequestMapping(value = "/Teacher", method=RequestMethod.GET)
	public ModelAndView getTeacherList(@ModelAttribute Account account){
		ModelAndView model=new ModelAndView("Teacher");
		account = (Account)context.getBean("account");
		System.out.println(account.getIdentity()+"HAHAHA");
		if(account.getIdentity()!=null/*||account.getIdentity()==""*/ /*){
			if(account.getIdentity().equals("secretary")){
				model=new ModelAndView("teacher-b");
			}else{
				model=new ModelAndView("teacher-b");
			}
		}
		return model;
	}
*/

	
	@RequestMapping(value = "/teacher-a", method = RequestMethod.GET)
	public ModelAndView getTeacherList(){
	
		ModelAndView model = new ModelAndView("Teacher");
		//logger.info("controller");
		TeacherDAO teacherDAO = (TeacherDAO)context.getBean("teacherDAO");
		List<Teacher> TeacherList = new ArrayList<Teacher>();
		TeacherList = teacherDAO.getTeacherList();
		//logger.info(""+teacherList.size());
		model.addObject("TeacherList", TeacherList);
		
		return model;
	}
	//SpecialtyList
	@RequestMapping(value = "/Teacher", method = RequestMethod.GET)
	public ModelAndView getSpecialtyList(){
	
		ModelAndView model=new ModelAndView("Teacher");
		// ModelAndView model = new ModelAndView("redirect:/Teacher");
		//logger.info("controller");
		TeacherDAO teacherDAO = (TeacherDAO)context.getBean("teacherDAO");
	
		//1 Specialty
		List<Teacher> SpecialtyList1 = new ArrayList<Teacher>();
		SpecialtyList1 = teacherDAO.getSpecialtyList(401);
		//logger.info(""+teacherList.size());
		model.addObject("SpecialtyList1", SpecialtyList1);
		
		// 2 Specialty
		List<Teacher> SpecialtyList2 = new ArrayList<Teacher>();
		SpecialtyList2 = teacherDAO.getSpecialtyList(402);
		//logger.info(""+teacherList.size());
		model.addObject("SpecialtyList2", SpecialtyList2);
		
		//3 Specialty
		List<Teacher> SpecialtyList3 = new ArrayList<Teacher>();
		SpecialtyList3 = teacherDAO.getSpecialtyList(403);
		//logger.info(""+teacherList.size());
		model.addObject("SpecialtyList3", SpecialtyList3);

		//4 Specialty
		List<Teacher> SpecialtyList4 = new ArrayList<Teacher>();
		SpecialtyList4 = teacherDAO.getSpecialtyList(404);
		//logger.info(""+teacherList.size());
		model.addObject("SpecialtyList4", SpecialtyList4);
	
		
		//5 Specialty
		List<Teacher> SpecialtyList5 = new ArrayList<Teacher>();
		SpecialtyList5 = teacherDAO.getSpecialtyList(405);
		//logger.info(""+teacherList.size());
		model.addObject("SpecialtyList5", SpecialtyList5);
	
		
		return model;
	}
	@RequestMapping(value = "/insertTeacher", method = RequestMethod.GET)
	public ModelAndView insertTeacherPage(){
		ModelAndView model = new ModelAndView("insertTeacher");
		//need the following part for product category
		/*
		ArticleCategoryDAO articleCategoryDAO = (ArticleCategoryDAO)context.getBean("articleCategoryDAO");
		List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
		articleCategoryList = articleCategoryDAO.getList();
		model.addObject("articleCategoryList", articleCategoryList);
		*/
		return model;
	}
	
	@RequestMapping(value = "/insertTeacher", method = RequestMethod.POST)
	public ModelAndView insertTeacher(@ModelAttribute Teacher teacher){
		ModelAndView model = new ModelAndView("redirect:/Teacher");
		TeacherDAO teacherDAO = (TeacherDAO)context.getBean("teacherDAO");
		teacherDAO.insert(teacher);
		
		return model;
	}

	/*
	@RequestMapping(value = "/updateTeacher", method = RequestMethod.GET)
	public ModelAndView updateTeacherPage(@ModelAttribute Teacher teacher){
		ModelAndView model = new ModelAndView("updateTeacher");
		TeacherDAO teacherDAO = (TeacherDAO)context.getBean("teacherDAO");
		//will need the following part later
		
		// ArticleCategoryDAO articleCategoryDAO = (ArticleCategoryDAO)context.getBean("articleCategoryDAO");
		// List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
		// articleCategoryList = articleCategoryDAO.getList();
		
		teacher = teacherDAO.get(teacher);
		//System.out.println("id="+product.getId());
		//will need the following part later
		//model.addObject("articleCategoryList", articleCategoryList);
		model.addObject("teacher", teacher);
		return model;
	}*/
	
	
	/*
	@RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
	public ModelAndView updateTeacher(@ModelAttribute Teacher teacher){
		ModelAndView model = new ModelAndView("redirect:/teacher");
		TeacherDAO teacherDAO = (TeacherDAO)context.getBean("teacherDAO");
		teacherDAO.update(teacher);	
		return model;
	}
	*/

	@RequestMapping(value = "/deleteTeacher", method = RequestMethod.POST)
	public ModelAndView deleteTeacher(@ModelAttribute Teacher teacher){
		ModelAndView model = new ModelAndView("redirect:/Teacher");
		TeacherDAO teacherDAO = (TeacherDAO)context.getBean("teacherDAO");
		teacherDAO.delete(teacher);
		return model;
	}


/*
	@RequestMapping(value = "/availableProduct", method = RequestMethod.GET)
	public ModelAndView listAvailableProduct(){
	
		ModelAndView model = new ModelAndView("availableProduct");
		//logger.info("controller");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		List<Product> productList = new ArrayList<Product>();
		productList = productDAO.getAvailableList();
		//logger.info(""+productList.size());
		model.addObject("productList", productList);
		
		return model;
	}
*/

}
