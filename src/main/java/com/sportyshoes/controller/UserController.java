package com.sportyshoes.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

import com.sportyshoes.dao.UserServices;
import com.sportyshoes.model.Users;



@RestController
public class UserController {
	
	
	@Autowired
	private UserServices userServices;
	
	//get all users
	@GetMapping("/api/user/all")
	public ResponseEntity <List<Users>> getUser()
	{	
		List<Users> list = userServices.getAllUsers();
		if (list.size()<=0) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	//get user by id
	@GetMapping("/api/user/{userId}")
	public ResponseEntity<Users> getUser(@PathVariable("userId") int userId){
		Users users = userServices.getUserById(userId);
		if (users==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(users));	
		}
	
    //get user by name
	@GetMapping("/api/user/search")
	public ResponseEntity<Users> getName(@RequestParam String name){
		Users users = userServices.getUserByName(name);
		if (users==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(users));	
		}
	
	//new user handler
	@PostMapping("/api/user/signup")
	public ResponseEntity<Users> addUser(@RequestBody Users user) {
		Users u =null;
		try {
			u = this.userServices.addUser(user);
			System.out.println(user);
			System.out.println("Welcome " +u.getName()+ " to sporty shoes");
			return ResponseEntity.status(HttpStatus.CREATED).build();
			
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
			
	}
	
	@PostMapping("/api/user/signin")
	public String userLogin(@RequestParam int userId, @RequestParam String password)
	{
		if(userServices.verifyUser(userId, password))
		{
			return "Login Successfull, \nWelcome to sporty shoes";
		}
		else
		{
			return "Login Failed";
		}
	}
	
	//delete user
	@DeleteMapping("/Users/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") int uId) {
		try {
			this.userServices.deleteUser(uId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}		
		
	}
	
	//update user
	@PutMapping("/Users/{userId}")
	public Users updateUser(@RequestBody Users user, @PathVariable("userId") int uId) {
		 this.userServices.updateUser(user, uId);
		return user;
		
	}
	
	@PatchMapping("/api/user/{userId}/changePassword/{newPassword}")
	public String changePassword(@PathVariable int userId, @PathVariable String newPassword)
	{
		userServices.changePassword(userId, newPassword);
		return "Password Changed Successfully";
	}
	
	@PatchMapping("/api/user/{userId}/changeName/{newName}")
	public String changeName(@PathVariable int userId, @PathVariable String newName)
	{
		userServices.changeName(userId, newName);
		return "User name Changed Successfully";
	}
	
}
