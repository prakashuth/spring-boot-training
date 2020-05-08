package com.med.springboot.moviecatalogservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATALOG")
public class CatalogItem {
	
	
	/*
	 * public CatalogItem(int id,String name,String desc,int rating) { this.id=id;
	 * this.name = name; this.desc = desc; this.rating=rating; }
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String name , desc;
	int rating;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
