package com.example.spring.pojo;

import javax.persistence.*;

@Entity
@Table(name="BRAND")
public class Brand {
	
	@Override
	public String toString() {
		return "Brand [item_id=" + item_id + ", brand_name=" + brand_name
				+ ", item_name=" + item_name + ", item_price=" + item_price
				+ "]";
	}
	@Id
	@Column(name="ITEM_NO")
	private int item_id;
	
	@Column(name="BRAND_NAME")
	private String brand_name;
	
	@Column(name="ITEM_NAME")
	private String item_name;
	
	@Column(name="ITEM_PRICE")
	private double item_price;
		
	
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getItem_price() {
		return item_price;
	}
	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}
	

}
