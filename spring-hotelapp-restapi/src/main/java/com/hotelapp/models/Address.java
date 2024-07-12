package com.hotelapp.models;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

public class Address {
	
	public Address(String city, long zipcode, String state) {
		super();
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
   @Id
	@GeneratedValue(generator = "add_id",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="add_id",sequenceName = "address_id")
    private Integer did;
	private String city;
	private long zipcode;
	private String state;
	public Integer getDno() {
		return did;
	}
	public void setDno(Integer dno) {
		this.did = dno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getZipcode() {
		return zipcode;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [ city=" + city + ", zipcode=" + zipcode + ", state=" + state + "]";
	}
	
	

}
