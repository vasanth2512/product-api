package com.hotelapp.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class ApiErrors {
   
	public ApiErrors() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiErrors(int statuscode, String error, HttpStatus status, LocalDateTime timestamp) {
		super();
		this.statuscode = statuscode;
		this.error = error;
		this.status = status;
		this.timestamp = timestamp;
	}
	private int statuscode;
	private String error;
	private 	HttpStatus status;
	private LocalDateTime timestamp;
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ApiErrors [statuscode=" + statuscode + ", error=" + error + ", status=" + status + ", timestamp="
				+ timestamp + "]";
	}
	
	
	
	
}
