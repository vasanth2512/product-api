

package com.hotelapp.models;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

public class Menu {
	
	
	 public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(String iname, double price) {
		super();
		this.iname = iname;
		this.price = price;
	}
	@Id
		@GeneratedValue(generator = "menu_id",strategy = GenerationType.AUTO)
		@SequenceGenerator(name="menu_id",sequenceName = "menu_id")
	private Integer menuid;
	private String iname;
	private double price;
	@ManyToOne
	private Hotel hotel;
	public Integer getMenuid() {
		return menuid;
	}
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	@Override
	public String toString() {
		return "Menu [iname=" + iname + ", price=" + price + "]";
	}
	
	

}
