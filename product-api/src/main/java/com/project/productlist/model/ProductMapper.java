package com.project.productlist.model;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

	public product convertToProduct(ProductDto productDto) {
	   product prod = new product();
	   prod.setBrand(productDto.getBrand());
		prod.setCategory(productDto.getCategory());
		prod.setFeat(productDto.getFeat());
		prod.setpId(productDto.getpId());
		prod.setPname(productDto.getPname());
		prod.setPrice(productDto.getPrice());
		return prod ;
		
	
  }

   public  ProductDto converttoDto(product prod) {
	   ProductDto productDto = new ProductDto();
	    productDto.setBrand(prod.getBrand());
		productDto.setCategory(prod.getCategory());
		productDto.setFeat(prod.getFeat());
		productDto.setpId(prod.getpId());
		productDto.setPname(prod.getPname());
		productDto.setPrice(prod.getPrice());
	   return productDto ;
   }
	
	


}