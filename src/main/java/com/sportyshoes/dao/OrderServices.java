package com.sportyshoes.dao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.sportyshoes.model.Orders;
import com.sportyshoes.repositories.OrderRepository;
import com.sportyshoes.repositories.ProductRepository;

@Component
public class OrderServices {
	@Autowired
	private OrderRepository orderRepository;
	
    
	public List<Orders> getAllOrders(){
		List<Orders> list = (List<Orders>) this.orderRepository.findAll();
		return list;		
	}
	
	//get orders sorted by field in ascending order
	public List<Orders> findOrderWithSorting(String field)
	 {
		 return orderRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	 }
	
	//get orders by orderId
	public Orders getOrderById(int orderId) {
		Orders order = null;
		try {
	 order = this.orderRepository.findById(orderId);
	}catch (Exception e) {
		e.printStackTrace();
	}
	return order;
	}
		
	public Orders addOrder(Orders order) {
		Orders results = orderRepository.save(order);
		return results;		
	}
	
	public void deleteOrder(int oId) {
		orderRepository.deleteById(oId);		
	}
	
	public void updateOrder(Orders order, int orderId) {
		order.setOrderId(orderId);
		orderRepository.save(order);
	}
}
