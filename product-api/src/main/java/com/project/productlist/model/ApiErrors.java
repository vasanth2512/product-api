package com.project.productlist.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiErrors {

	public ApiErrors() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiErrors(LocalDateTime timestamp, String error, int ststuscode, HttpStatus ststus) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.ststuscode = ststuscode;
		this.ststus = ststus;
	}
	private LocalDateTime timestamp;
	private String error;
	private int ststuscode;
	private HttpStatus ststus;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getStstuscode() {
		return ststuscode;
	}
	public void setStstuscode(int ststuscode) {
		this.ststuscode = ststuscode;
	}
	public HttpStatus getStstus() {
		return ststus;
	}
	public void setStstus(HttpStatus ststus) {
		this.ststus = ststus;
	}
	@Override
	public String toString() {
		return "ApiErrors [timestamp=" + timestamp + ", error=" + error + ", ststuscode=" + ststuscode + ", ststus="
				+ ststus + "]";
	}
	
	
}
