package com.sportyshoes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.model.Products;

public interface ProductRepository extends CrudRepository <Products, Integer>{
	public Products findById(int productId);
	public Products findByProductName(String productName);
	

}
