package com.project.productlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.productlist.exception.IDNotFoundException;
import com.project.productlist.exception.ProductNotFoundException;
import com.project.productlist.model.ProductDto;
import com.project.productlist.model.ProductMapper;
import com.project.productlist.model.product;
import com.project.productlist.repository.Iproductrepository;


@Service
public class ProductServiceImpl implements IproductService{
	
	
	
	public ProductServiceImpl(Iproductrepository productrepo) {
		super();
		this.productrepo = productrepo;
	}

	private Iproductrepository productrepo;
	
	@Autowired
	private ProductMapper productmapper;

	
	

	@Override
	public void addProduct(ProductDto productDto) {
        product prod =  productmapper.convertToProduct(productDto);
	    productrepo.insert(prod);
	     
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		product prod = productmapper.convertToProduct(productDto);
		productrepo.save(prod);
		
	}

	@Override
	public void DeleteProduct(String pId) {
		productrepo.deleteById(pId);
		
	}

	@Override
	public List<ProductDto> getAll() {
	   List<product> prod1 = productrepo.findAll();
	      List<ProductDto> productDto =	prod1.stream().map(prod -> productmapper.converttoDto(prod))
		.toList();
		return productDto;
	}

	@Override
	public ProductDto getById(String pId) throws IDNotFoundException {
		       product prod = productrepo.findById(pId)
		    		   .orElseThrow(()->new IDNotFoundException(" INVALID ID") );
		       return productmapper.converttoDto(prod);
		       
	}

	@Override
	public List<ProductDto> getByBrand(String brand) throws ProductNotFoundException {
		     List<product> prod1 = productrepo.findBYBrand(brand);
		      if(prod1.isEmpty()) 
		    	  throw new ProductNotFoundException("PRODUCT WITH THIS BRAND NOT AVALIABLE");
		    List<ProductDto> productDto = prod1.stream().map(prod -> productmapper.converttoDto(prod))
		  .toList();
		return productDto;
	}

	@Override
	public List<ProductDto> getByCategory(String[] category) throws ProductNotFoundException {
          List<product> prod1 = productrepo.findByCategory(category);
        		if(prod1.isEmpty())  throw new ProductNotFoundException("PRODUCT WITH THIS CATEGORY IS NOT AVAILABLE");
        	List<ProductDto> productDto = prod1.stream().map(prod -> productmapper.converttoDto(prod)).toList();
		return productDto;
	}

}
