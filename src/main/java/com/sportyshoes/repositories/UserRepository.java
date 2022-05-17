package com.sportyshoes.repositories;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.model.Users;

public interface UserRepository extends CrudRepository <Users, Integer>{
public Users findById(int userId);
public Users findByName(String name);
//	

}
