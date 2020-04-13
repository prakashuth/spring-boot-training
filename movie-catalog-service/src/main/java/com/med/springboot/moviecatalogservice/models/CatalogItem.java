package com.med.springboot.moviecatalogservice.models;

public class CatalogItem {
	
	public CatalogItem(String name,String desc,int rating) {
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}
	
	private String name;
	private String desc;
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
	public int getRatings() {
		return rating;
	}
	public void setRatings(int ratings) {
		this.rating = ratings;
	}
	private int rating;

}
