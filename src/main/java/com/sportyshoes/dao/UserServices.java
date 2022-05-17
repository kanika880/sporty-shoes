package com.sportyshoes.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportyshoes.model.Admin;
import com.sportyshoes.model.Users;
import com.sportyshoes.repositories.UserRepository;

@Component
public class UserServices{
	
	@Autowired
	private UserRepository userRepository;
	
	//user sign in
		public Boolean verifyUser(int userId, String password)
		{
			List<Users> users = (List<Users>) userRepository.findAll();
			
			for(Users user : users)
			{
				if(user.getUserId()==userId && user.getPassword().equals(password)) 
				{
					return true;
				}
			}
			return false;
		}
	
	public List<Users> getAllUsers(){
		List<Users> list = (List<Users>)this.userRepository.findAll();
		return list;
		
	}
	
	public Users getUserById(int userId) {
		Users user = null;
		try {
			user = userRepository.findById(userId);
		}catch (Exception e) {
			e.printStackTrace();
		}
	return user;
		
	}
	
	public Users getUserByName(String name) {
		Users user = null;
		try {
			user = this.userRepository.findByName(name);
		}catch (Exception e) {
			e.printStackTrace();
		}
	return user;
		
	}
	
	public Users addUser(Users user1) {
		Users results = userRepository.save(user1);
		return results;
		
	}
	
	public void deleteUser(int uId) {
		userRepository.deleteById(uId);
	}
	
	public void updateUser(Users user, int userId) {
		user.setUserId(userId);
		userRepository.save(user);
	}
	
	public void changePassword(int userId, String newPassword)
	{
		Users users = userRepository.findById(userId);
		
		users.setPassword(newPassword);
		
		userRepository.save(users);
		
		System.out.println("Password Changed Successfully");
	}
	
	public void changeName(int userId, String newName)
	{
		Users users = userRepository.findById(userId);
		
		users.setName(newName);
		
		userRepository.save(users);
		
		System.out.println("User name Changed Successfully");
	}

	
}