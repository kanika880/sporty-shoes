package com.sportyshoes.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportyshoes.model.Admin;
import com.sportyshoes.repositories.AdminRepository;

@Component
public class AdminServices {
	
	@Autowired
	private AdminRepository adminRepository;

	//admin sign in
	public Boolean verifyAdmin(int adminId, String password)
	{
		List<Admin> admins = (List<Admin>) adminRepository.findAll();
		
		for(Admin admin : admins)
		{
			if(admin.getAdminId()==adminId && admin.getPassword().equals(password)) 
			{
				return true;
			}
		}
		return false;
	}
	
	public void changePassword(int adminId, String newPassword)
	{
		Admin admin = adminRepository.findById(adminId).get();
		
		admin.setPassword(newPassword);
		
		adminRepository.save(admin);
		
		System.out.println("Password Changed Successfully");
	}
	
	//view orders of given product by product id
	
	//orders sorted by date and id
	
	//orders for user by user id
}
