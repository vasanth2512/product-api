package com.project.productlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.productlist.exception.IDNotFoundException;

import com.project.productlist.model.ProductDto;
import com.project.productlist.service.IproductService;

@RestController
@RequestMapping("/product-api/ ")

public class ProductController {
	
	@Autowired
	IproductService productservice;

  @PostMapping("/products")
     ResponseEntity<Void> addProduct( @RequestBody  ProductDto productDto) {
    	 productservice.addProduct(productDto);
    	 return ResponseEntity.status(HttpStatusCode.valueOf(201)).build() ;
     }
  
  
  
  @PutMapping("/products")
  ResponseEntity<Void> updateProduct(  @RequestBody ProductDto productDto) {
		productservice.updateProduct(productDto);
		return ResponseEntity.status(HttpStatusCode.valueOf(202)).build();
		
		}
  
  @DeleteMapping("/products/productid/{pid}")
  ResponseEntity<Void> DeleteProduct( @PathVariable("pid")String pId) {
	  productservice.DeleteProduct(pId);
	  return ResponseEntity.status(202).build();
	  
  }
	@GetMapping("/products")
ResponseEntity<List<ProductDto>> getAll(){
	List<ProductDto> productDto	= productservice.getAll();
	HttpHeaders header = new HttpHeaders();
	header.add("info", "GETTING ALL PRODUCTS");
  return ResponseEntity.status(200).headers(header).body(productDto);	
	}


    @GetMapping("/products/productid/{pid}")
  ResponseEntity<ProductDto> getById( @PathVariable("pid") String pId) throws IDNotFoundException {
		      ProductDto productDto = productservice.getById(pId);
		HttpHeaders header = new HttpHeaders();
		header.add("info"," GET PRODUCT BY ID ");
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).headers(header).body(productDto);
		
	}
	
    @GetMapping("/products/productbrand/{brand}")
	ResponseEntity<List<ProductDto>> getByBrand( @PathVariable("brand")String brand){
    	List<ProductDto> productDto = productservice.getByBrand(brand);
    	HttpHeaders header = new HttpHeaders();
    	header.add("info", "GET PRODUCT BY BRAND");
		return ResponseEntity.status(200).headers(header).body(productDto);
	}
    
    
    @GetMapping("/products/productcategory/{category}")
	ResponseEntity<List<ProductDto>> getByCategory( @PathVariable("category")  String[] category){
    	List<ProductDto> productDto = productservice.getByCategory(category);
    	return ResponseEntity.ok(productDto);
	}
	
	
}
