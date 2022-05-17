package com.sportyshoes.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.model.Orders;

public interface OrderRepository extends CrudRepository <Orders, Integer>{
	public Orders findById(int orderId);
	public Orders findByProductId(int productId);
	//public Orders findByOrderName(String orderName);
	public List<Orders> findAll(Sort sortOrder);
	

}
