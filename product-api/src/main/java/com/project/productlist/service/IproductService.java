package com.project.productlist.service;

import java.util.List;

import com.project.productlist.exception.IDNotFoundException;
import com.project.productlist.exception.ProductNotFoundException;
import com.project.productlist.model.ProductDto;

public interface IproductService {
	
//	crud operations
	
	void addProduct(ProductDto productDto) ;
	void updateProduct(ProductDto productDto);
	void DeleteProduct(String pId);
	
	List<ProductDto> getAll();
	ProductDto getById(String pId) throws IDNotFoundException;
	
	List<ProductDto> getByBrand(String brand) throws ProductNotFoundException; 
	List<ProductDto> getByCategory(String[] category)throws ProductNotFoundException; 

}
