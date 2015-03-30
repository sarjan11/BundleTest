package com.example.spring.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="ITEM")
public class Item {
	private String item_name;

}
