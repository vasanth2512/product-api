package com.hotelapp.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hotelapp.models.ApiErrors;



@ControllerAdvice
public class GlobalException  extends ResponseEntityExceptionHandler  {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		int statuscode = status.value();
		String error = ex.getMessage();
		HttpStatus httpstatus = HttpStatus.valueOf(statuscode) ;
		headers.add("desc", "METHOD NOT SUPPORT EXCEPTION");
		headers.add("info", ex.getMessage());
        ApiErrors api = new ApiErrors(statuscode,error,httpstatus,LocalDateTime.now());
	   return ResponseEntity.status(httpstatus).headers(headers).body(api);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		int statuscode = status.value();
		String error = ex.getMessage();
		HttpStatus httpstatus = HttpStatus.valueOf(statuscode);
		headers.add("desc", "MEDIA TYPE NOT SUPPORTED EXCEPTION");
		headers.add("info", ex.getMessage());
		ApiErrors api = new ApiErrors(statuscode,error,httpstatus,LocalDateTime.now());
		return  ResponseEntity.status(httpstatus).headers(headers).body(api);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		int statuscode = status.value();
		String error = ex.getMessage();
		HttpStatus httpstatus = HttpStatus.valueOf(statuscode);
		headers.add("desc", "MISSING PATH VARIABLE EXCEPTION");
		headers.add("info", ex.getMessage());
		ApiErrors api = new ApiErrors(statuscode,error,httpstatus,LocalDateTime.now());
		return ResponseEntity.status(httpstatus).headers(headers).body(api);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		int statuscode = status.value();
		String error = ex.getMessage();
		HttpStatus httpstatus = HttpStatus.valueOf(statuscode);
		headers.add("desc", "Servlet Request Parameter Exception");
		headers.add("info", ex.getMessage());
		ApiErrors api = new ApiErrors(statuscode,error,httpstatus,LocalDateTime.now());
		return ResponseEntity.status(statuscode).headers(headers).body(api);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		int statuscode = status.value();
		String error = ex.getMessage();
		HttpStatus httpstatus = HttpStatus.valueOf(statuscode);
		headers.add("desc", "TYPE MISMATCH EXCEPTION");
		headers.add("info", ex.getMessage());
		ApiErrors api = new ApiErrors(statuscode,error,httpstatus,LocalDateTime.now());
		return ResponseEntity.status(httpstatus).headers(headers).body(api);
	}

	@ExceptionHandler(IDNotFoundException.class)
	protected ResponseEntity<Object>IDNotFoundException(IDNotFoundException ex){
		HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
		int statuscode = status.value();
		String error = ex.getMessage();
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "ID NOT FOUND EXCEPYION");
		header.add("info", ex.getMessage());
		ApiErrors api = new ApiErrors(statuscode,error,status,LocalDateTime.now());
		return ResponseEntity.status(HttpStatusCode.valueOf(statuscode)).headers(header).body(api);
	}

	
	@ExceptionHandler(HotelNotFoundException.class)
  protected ResponseEntity<Object>HotelNotFoundException(HotelNotFoundException ex){
	  HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
	  int statuscode = status.value();
	  String error = ex.getMessage();
	  HttpHeaders header = new HttpHeaders();
	  header.add("desc", "HOTEL NOT FOUND EXCEPTION");
	  header.add("info", ex.getMessage());
	  ApiErrors api = new ApiErrors (statuscode,error,status,LocalDateTime.now());
	  return   ResponseEntity.status(HttpStatusCode.valueOf(statuscode)).headers(header).body(api);
  }

	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object>HandleOtherException(Exception ex){
	   HttpStatus status = HttpStatus.BAD_REQUEST;
	   int statuscode = status.value();
	   String error = ex.getMessage();
	   HttpHeaders header = new HttpHeaders();
	   header.add("desc", "UNIDENTIFY EXCEPTIOn");
	   header.add("info", ex.getMessage());
		ApiErrors api = new ApiErrors(statuscode,error,status,LocalDateTime.now());
	   return  ResponseEntity.status(HttpStatusCode.valueOf(statuscode)).headers(header).body(api);
	}


}
