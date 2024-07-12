package com.hotelapp.models;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;


public class Hotel {

	
	public Hotel(String hotelname, Address address, Set<Menu> menulist, Set<Delivery> delivery) {
		super();
		this.hotelname = hotelname;
		this.address = address;
		this.menulist = menulist;
		this.delivery = delivery;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(generator = "hotel_id",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="hotel_id",sequenceName = "hotel_id")
	private Integer hotelId;
	private String hotelname;
	@OneToOne
	@Autowired
	private Address address;
	@OneToMany
	private Set<Menu> menulist;
	@ManyToMany
	private Set<Delivery> delivery;
	@Override
	public String toString() {
		return "Hotel [hotelname=" + hotelname + ", address=" + address + ", menulist=" + menulist + ", delivery="
				+ delivery + "]";
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Menu> getMenulist() {
		return menulist;
	}
	public void setMenulist(Set<Menu> menulist) {
		this.menulist = menulist;
	}
	public Set<Delivery> getDelivery() {
		return delivery;
	}
	public void setDelivery(Set<Delivery> delivery) {
		this.delivery = delivery;
	}
	
	
	
	
}
