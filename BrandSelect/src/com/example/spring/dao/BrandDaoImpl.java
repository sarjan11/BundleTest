package com.example.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.example.spring.pojo.Brand;


@Service
public class BrandDaoImpl implements BrandDao{
	
private HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate=new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveBrand(Brand brand) {
		// TODO Auto-generated method stub
			
				hibernateTemplate.saveOrUpdate(brand);
	}

	@Override
	@SuppressWarnings("Unchecked")
	public List<Brand> listBrand() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Brand");
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<Brand> listByCategory(String category) {
		// TODO Auto-generated method stub
		Object[] queryParam={category};
		return hibernateTemplate.find("from Brand where brand_name=?",queryParam);
		
		List<Brand> brands= hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Brand.class)
				.add(Restrictions.eq("brand_name", category)));
		
		Brand brd=new Brand();
		brd.setBrand_name(category);
		List<Brand> brands= hibernateTemplate.findByExample(brd);
		DetachedCriteria criteria=DetachedCriteria.forClass(Brand.class);
		criteria.add(Restrictions.eq("brand_name", category));
		
		List<Brand> brands=hibernateTemplate.findByCriteria(criteria);
		
		for(Brand b: brands){
			System.out.println(b+"\n");
			
		}
		
		return brands;
		
	}
	*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> listByChoice(String b_name, String i_name) {
		// TODO Auto-generated method stub
	/*	DetachedCriteria criteria=DetachedCriteria.forClass(Brand.class);
		
		criteria.add(Restrictions.eq("brand_name", item_brand));
		criteria.add(Restrictions.eq("item_name",item_name));
		
		
		List<Brand> brands=hibernateTemplate.findByCriteria(criteria);
		
		for(Brand b: brands){
			System.out.println(b+"\n");
			
		}
		
		return brands;*/
		
				
		List<Brand> brands=hibernateTemplate.find("from Brand where brand_name=? and item_name=?", 
				new Object[]{b_name,i_name});
		
		for(Brand b: brands){
			System.out.println(b+"\n");
			
		}
		
		return brands;
	}

}
