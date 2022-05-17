package com.sportyshoes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.dao.ProductServices;
import com.sportyshoes.model.Products;

@RestController
public class ProductController {

	
	@Autowired
	private ProductServices productServices;
	
//	get all products
	@GetMapping("/api/products/all")
	public ResponseEntity <List<Products>> getProducts()
	{	
		List<Products> list = productServices.getAllProducts();
		if (list.size()<=0) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	//get product by id
	@GetMapping("/api/products/{productId}")
	public ResponseEntity<Products> getProducts(@PathVariable("productId") int productId){
		Products products = productServices.getProductById(productId);
		if (products==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(products));	
		}
	
	
    //get product by name
	@GetMapping("/api/products/search")
	public Products getProductName(@RequestParam (value = "productName") String productName){
		Products products = productServices.getProductByName(productName);
		if (products==null) {
			return null;
		}else {
		return  products;	
		}}
	
	//new product handler
	@PostMapping("/api/products/add")
	public ResponseEntity<Products> addProduct(@RequestBody Products product) {
		Products p =null;
		try {
			p = this.productServices.addProduct(product);
			System.out.println(product);
			return ResponseEntity.status(HttpStatus.CREATED).build();
			
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
			
	}
	
	//delete product
	@DeleteMapping("/api/products/{productId}/delete")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") int pId) {
		try {
			this.productServices.deleteProduct(pId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}		
		
	}
	
	//update product
	@PutMapping("/Products/{productId}")
	public Products updateProduct(@RequestBody Products product, @PathVariable("productId") int pId) {
		 this.productServices.updateProduct(product, pId);
		return product;
		
	}
	
	@PatchMapping("/api/products/{productId}/changeName/{newName}")
	public String changeName(@PathVariable int productId, @PathVariable String newName)
	{
		productServices.changeName(productId, newName);
		return "Product name Changed Successfully";
	}
	
	@PatchMapping("/api/products/{productId}/changeMsrp/{newMsrp}")
	public String changeMsrp(@PathVariable int productId, @PathVariable float newMsrp)
	{
		productServices.changeMsrp(productId, newMsrp);
		return "MSRP Changed Successfully";
	}
	
	@PatchMapping("/api/products/{productId}/changeQuantityInStock/{newQIS}")
	public String changeQuantityInStock(@PathVariable int productId, @PathVariable int newQIS)
	{
		productServices.changeQuantityInStock(productId, newQIS);
		return "QuantityInStock Changed Successfully";
	}
	
	@PatchMapping("/api/products/{productId}/changeProductVendor/{newPv}")
	public String changeProductVendor(@PathVariable int productId, @PathVariable String newPv)
	{
		productServices.changeProductVendor(productId, newPv);
		return "ProductVendor Changed Successfully";
	}
	
	
	

}
