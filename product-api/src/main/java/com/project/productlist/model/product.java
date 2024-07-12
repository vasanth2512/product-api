package com.project.productlist.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class product {
	
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product(String pname, String pId, String[] category, String brand, double price, features feat) {
		super();
		this.pname = pname;
		this.pId = pId;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.feat = feat;
	}
	private String pname;
	@Id
	private String pId;
	private String[] category;
	private String brand;
	private double price;
	private features feat;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String[] getCategory() {
		return category;
	}
	public void setCategory(String[] category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public features getFeat() {
		return feat;
	}
	public void setFeat(features feat) {
		this.feat = feat;
	}
	@Override
	public String toString() {
		return "product [pname=" + pname + ", pId=" + pId + ", category=" + Arrays.toString(category) + ", brand="
				+ brand + ", price=" + price + ", feat=" + feat + "]";
	}
	
	
	

}
