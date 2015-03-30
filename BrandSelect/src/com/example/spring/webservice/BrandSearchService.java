package com.example.spring.webservice;

import java.util.List;

import javax.jws.WebMethod;


import javax.jws.WebService;

import com.example.spring.dao.BrandDaoImpl;
import com.example.spring.pojo.Brand;


@WebService(serviceName="BrandSearch")
public class BrandSearchService{
	
	
	private BrandDaoImpl brandDaoImpl;
	
	
	@WebMethod
	public void saveBrand(Brand brand) {
		brandDaoImpl.saveBrand(brand);
		
	}

	
	@WebMethod
	public List<Brand> listBrand() {
		return brandDaoImpl.listBrand();
	}

	
	@WebMethod
	public List<Brand> listByChoice(String item_brand, String item_name) {
		return brandDaoImpl.listByChoice(item_brand, item_name);
	}

}
