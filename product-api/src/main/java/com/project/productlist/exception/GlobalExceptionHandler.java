package com.project.productlist.exception;

import java.time.LocalDateTime;
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

import com.project.productlist.model.ApiErrors;


@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	 int statusCode = status.value();
	 String error = ex.getMessage();
	 HttpStatus header = HttpStatus.valueOf(statusCode);
	 headers.add("info", "METHOD NOT SUPPORT EXCEPTION");
		ApiErrors api = new ApiErrors(LocalDateTime.now(),error,statusCode,header);
	  return ResponseEntity.status(status).headers(headers).body(api);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	  int statuscode = status.value();
	  String error = ex.getMessage();
	  HttpStatus header = HttpStatus.valueOf(statuscode);
	  headers.add("info", "TYPE NOT SUPPORT EXCEPTION");
		ApiErrors api = new ApiErrors(LocalDateTime.now(),error,statuscode,header);
	   return ResponseEntity.status(status).headers(headers).body(api);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		int statuscode = status.value();
		String error = ex.getMessage();
		HttpStatus header = HttpStatus.valueOf(statuscode);
		headers.add("info", "PATHVARIABLE MISSING EXCEPTION");
       ApiErrors api = new ApiErrors(LocalDateTime.now(),error,statuscode,header);
		
		return ResponseEntity.status(status).headers(headers).body(api);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		int statuscode = status.value();
		String error = ex.getMessage();
		HttpStatus header = HttpStatus.valueOf(statuscode);
		headers.add("info", "MISSING REQUESTPARAMETER EXCEPTION");
       ApiErrors api = new ApiErrors(LocalDateTime.now(),error,statuscode,header);
		
		return ResponseEntity.status(status).headers(headers).body(api);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		int statuscode = status.value();
		String error = ex.getMessage();
		HttpStatus header = HttpStatus.valueOf(statuscode);
		headers.add("info", "TYPE MISMATCH EXCEPTION");
       ApiErrors api = new ApiErrors(LocalDateTime.now(),error,statuscode,header);
		return ResponseEntity.status(status).headers(headers).body(api);

      }

	
	@ExceptionHandler(IDNotFoundException.class)
    protected ResponseEntity<Object> handleIdNotFoud(IDNotFoundException ex){
		
    	HttpStatus httpstatus = HttpStatus.NOT_ACCEPTABLE;
    	String error = ex.getMessage();
    	HttpHeaders header = new HttpHeaders();
    	header.add("info", ex.getMessage());
    	int statuscode = httpstatus.value();
    	ApiErrors api = new ApiErrors(LocalDateTime.now(),error,statuscode,httpstatus);
    	return  ResponseEntity.status(HttpStatusCode.valueOf(statuscode)).headers(header).body(api);
    	
    	
    }

   @ExceptionHandler(ProductNotFoundException.class)
  protected  ResponseEntity<Object> handleProductNotFoun(ProductNotFoundException ex) {
	   HttpStatus httpstatus = HttpStatus.NOT_ACCEPTABLE;
   	String error = ex.getMessage();
   	HttpHeaders header = new HttpHeaders();
   	header.add("info", ex.getMessage());
   	int statuscode = httpstatus.value();
   	ApiErrors api = new ApiErrors(LocalDateTime.now(),error,statuscode,httpstatus);
   	return  ResponseEntity.status(HttpStatusCode.valueOf(statuscode)).headers(header).body(api);
   	
   }
   
   @ExceptionHandler(Exception.class)
   protected  ResponseEntity<Object> handleException(Exception ex) {
 	   HttpStatus httpstatus = HttpStatus.BAD_REQUEST;
    	String error = ex.getMessage();
    	HttpHeaders header = new HttpHeaders();
    	header.add("info", ex.getMessage());
    	int statuscode = httpstatus.value();
    	ApiErrors api = new ApiErrors(LocalDateTime.now(),error,statuscode,httpstatus);
    	return  ResponseEntity.status(HttpStatusCode.valueOf(statuscode)).headers(header).body(api);
    	
    }



}
