package com.sportyshoes.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportyshoes.model.Products;
import com.sportyshoes.model.Users;
import com.sportyshoes.repositories.ProductRepository;

@Component
public class ProductServices {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Products> getAllProducts(){
		List<Products> list = (List<Products>)this.productRepository.findAll();
		return list;
		
	}
	
	public Products getProductById(int productId) {
		Products product = null;
		try {
			product = this.productRepository.findById(productId);
		}catch (Exception e) {
			e.printStackTrace();
		}
	return product;
		
	}
	
	public Products getProductByName(String productName) {
		Products product = null;
		try {
			product = this.productRepository.findByProductName(productName);
		}catch (Exception e) {
			e.printStackTrace();
		}
	return product;
		
	}
	
	public Products addProduct(Products product1) {
		Products results = productRepository.save(product1);
		return results;
		
	}
	
	public void deleteProduct(int pId) {
		productRepository.deleteById(pId);
	}
	
	public void updateProduct(Products product, int productId) {
		product.setProductId(productId);
		productRepository.save(product);
	}
	
	public void changeName(int productId, String newName)
	{
		Products products = productRepository.findById(productId);
		
		products.setProductName(newName);
		
		productRepository.save(products);
		
		System.out.println("Product name Changed Successfully");
	}
	
	public void changeMsrp(int productId, float newMsrp)
	{
		Products products = productRepository.findById(productId);
		
		products.setMSRP(newMsrp);
		
		productRepository.save(products);
		
		System.out.println("MSRP Changed Successfully");
	}
	
	public void changeQuantityInStock(int productId, int newQIS)
	{
		Products products = productRepository.findById(productId);
		
		products.setQuantityInStock(newQIS);
		
		productRepository.save(products);
		
		System.out.println("QuantityInStock Changed Successfully");
	}
	
	public void changeProductVendor(int productId, String newPv)
	{
		Products products = productRepository.findById(productId);
		
		products.setProductVendor(newPv);
		
		productRepository.save(products);
		
		System.out.println("ProductVendor Changed Successfully");
	}
}


