package com.sportyshoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="product")
public class Products {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name = "product_id")
	private int productId;
	
	@Column (name = "Product_name")
	private String productName;
	
	@Column (name = "Quantity_in_stock")
	private int quantityInStock;
	
	@Column (name = "Product_vendor")
	private String productVendor;
	
	@Column (name = "MSRP")
	private float MSRP;

	public Products() {
		super();
		
	}

	public Products(int productId, String productName, int quantityInStock, String productVendor, float mSRP) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantityInStock = quantityInStock;
		this.productVendor = productVendor;
		this.MSRP = mSRP;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public float getMSRP() {
		return MSRP;
	}

	public void setMSRP(float mSRP) {
		MSRP = mSRP;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", quantityInStock="
				+ quantityInStock + ", productVendor=" + productVendor + ", MSRP=" + MSRP + "]";
	}
	
	
	
	
	
	
	

}
