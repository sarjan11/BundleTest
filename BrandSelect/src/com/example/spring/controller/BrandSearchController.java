package com.example.spring.controller;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.example.spring.dao.BrandDao;
import com.example.spring.pojo.Brand;


@Controller
public class BrandSearchController extends MultiActionController{
	
	@Autowired
	private BrandDao brandDao;
	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}
	
	
	@RequestMapping(value="welcome")
	public ModelAndView welcome(HttpServletRequest request,HttpServletResponse response,Brand brand) throws Exception{
		ModelMap modelMap2 = new ModelMap();
		modelMap2.addAttribute("brand",new Brand());
		return new ModelAndView("brandForm",modelMap2);
		
	}
	
	
	@RequestMapping(value="/add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response,Brand brand) throws Exception{
		
		brandDao.saveBrand(brand);
		return new ModelAndView("redirect:listByChoice.htm");
	}
	
/*	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("brandList",brandDao.listBrand());
		modelMap.addAttribute("brand",new Brand());
		return new ModelAndView("brandSearch",modelMap);
		//return new ModelAndView("brandForm",modelMap);
	}*/
	
/*	@RequestMapping(value="/listByCategory")
	public ModelAndView listByCategory(HttpServletRequest request,HttpServletResponse response, @ModelAttribute("brand") Brand brand) throws Exception{
		ModelMap modelMap1=new ModelMap();
		modelMap1.addAttribute("brandList",brandDao.listByCategory(brand.getBrand_name()));
		modelMap1.addAttribute("brand",new Brand());		
		return new ModelAndView("brandSearch",modelMap1);
	}*/
	

	@RequestMapping(value="/listByChoice")
	public ModelAndView listByChoice(HttpServletRequest request,HttpServletResponse response, @ModelAttribute("brand") Brand brand) throws Exception{
		ModelMap modelMap1=new ModelMap();
		modelMap1.addAttribute("brandList",brandDao.listByChoice(brand.getBrand_name(),brand.getItem_name()));
		modelMap1.addAttribute("brand",new Brand());		
		return new ModelAndView("brandSearch",modelMap1);
	}
	

}
