package com.hotelapp.models;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

public class Delivery {
	
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Delivery(String partnername, double charges) {
		super();
		this.partnername = partnername;
		this.charges = charges;
	}
	@Id
	@GeneratedValue(generator = "pid_id",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="pid_id",sequenceName = "productid_id")
	private Integer pid;
	private String partnername;
    private double charges;
    @ManyToMany(mappedBy = "delivery")
     private Set<Hotel> hotellist = new HashSet<>();
	@Override
	public String toString() {
		return "Delivery [partnername=" + partnername + ", charges=" + charges + "]";
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPartnername() {
		return partnername;
	}
	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}
	public double getCharges() {
		return charges;
	}
	public void setCharges(double charges) {
		this.charges = charges;
	}
	public Set<Hotel> getHotellist() {
		return hotellist;
	}
	public void setHotellist(Set<Hotel> hotellist) {
		this.hotellist = hotellist;
	} 
}
