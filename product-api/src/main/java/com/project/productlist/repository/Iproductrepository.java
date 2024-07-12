package com.project.productlist.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.productlist.model.product;

@Repository
public interface Iproductrepository extends MongoRepository<product,String> {

	
	List<product> findBYBrand(String brand);
	List<product> findByCategory(String[] category );
	
}
