package com.sportyshoes.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name ="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name = "Order_id")
	private int orderId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Products productId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Users userId;
	
	@Column (name = "Order_date")
	private String orderDate;

	public Orders() {
		super();
	}

	public Orders(int orderId, Products productId, Users userId, String orderDate) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.userId = userId;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Products getProductId() {
		return productId;
	}

	public void setProductId(Products productId) {
		this.productId = productId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", productId=" + productId + ", userId=" + userId + ", orderDate="
				+ orderDate + "]";
	}
	
}
