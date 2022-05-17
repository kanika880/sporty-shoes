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

import com.sportyshoes.dao.AdminServices;
import com.sportyshoes.dao.ProductServices;
import com.sportyshoes.dao.UserServices;
import com.sportyshoes.model.Products;
import com.sportyshoes.model.Users;

@RestController
public class AdminController {
	@Autowired
	private AdminServices adminServices;
	
	@Autowired
	private UserController userController;
	
	@Autowired
	private ProductController productController;
	
	@PostMapping("/api/admin/signin")
	public String adminLogin(@RequestParam int adminId, @RequestParam String password)
	{
		if(adminServices.verifyAdmin(adminId, password))
		{
			return "Login Successfull";
		}
		else
		{
			return "Login Failed";
		}
	}
	
	@PatchMapping("/api/admin/{adminId}/changePassword/{newPassword}")
	public String changePassword(@PathVariable int adminId, @PathVariable String newPassword)
	{
		adminServices.changePassword(adminId, newPassword);
		return "Password Changed Successfully";
	}
	
    
	
	

}
