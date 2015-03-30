package com.example.spring.dao;

import java.util.List;



import com.example.spring.pojo.Brand;



public interface BrandDao {
	public void saveBrand(Brand brand);
	public List<Brand> listBrand();
//	public List<Brand> listByCategory(String category);
	public List<Brand> listByChoice(String item_brand,String item_name);
	

}
