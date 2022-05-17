package com.sportyshoes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.model.Admin;
import com.sportyshoes.model.Users;

public interface AdminRepository extends CrudRepository <Admin, Integer> {
//	public Users findById(int adminId);
//	public Users findByName(String adminName);

}
