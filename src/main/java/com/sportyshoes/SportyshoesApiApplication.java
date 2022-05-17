package com.sportyshoes;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SportyshoesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyshoesApiApplication.class, args);
		System.out.println("spring boot application works");
		
		//UserRepository userRepository=context.getBean(UserRepository.class);
		//Users user = new Users();
		//user.setName("Mahima");
		//user.setPassword("12345");
		//Users user1 = userRepository.save(user);
		//System.out.println(user);
	}

}
