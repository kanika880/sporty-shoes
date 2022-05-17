package com.sportyshoes.controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.dao.OrderServices;
import com.sportyshoes.model.Orders;
import com.sportyshoes.model.Products;

@RestController
public class OrderController {
	
	@Autowired
	private OrderServices orderServices;
	
	//get all orders
	@GetMapping("/orders/all")
	public ResponseEntity <List<Orders>> getOrders()
	{	
		List<Orders> list = orderServices.getAllOrders();
		if (list.size()<=0) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/api/orders/all/sorted/{field}")
	public List<Orders> getOrderwithSort(@PathVariable String field) {
		List<Orders> allOrders = orderServices.findOrderWithSorting(field);
		return allOrders;
	}
	
	//get order by id
		@GetMapping("/orders/{orderId}")
		public ResponseEntity<Orders> getOrdersbyOrderId(@PathVariable("orderId") int orderId){
			Orders orders = orderServices.getOrderById(orderId);
			if (orders==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(orders));	
			}
		
	
		//new order handler
		@PostMapping("/orders/add")
		public ResponseEntity<Orders> addOrder(@RequestBody Orders order) {
			Orders o =null;
			try {
				o = this.orderServices.addOrder(order);
				System.out.println(order);
				return ResponseEntity.status(HttpStatus.CREATED).build();
				
			}catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
				
		}
		
		//delete order
		@DeleteMapping("/orders/delete/{orderId}")
		public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") int oId) {
			try {
				this.orderServices.deleteOrder(oId);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}		
			
		}
		
		//update order
		@PutMapping("/Orders/{orderId}")
		public Orders updateOrder(@RequestBody Orders order, @PathVariable("orderId") int oId) {
			 this.orderServices.updateOrder(order, oId);
			return order;
			
		}
		

}
