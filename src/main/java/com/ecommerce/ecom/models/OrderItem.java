package com.ecommerce.ecom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderItemID;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private double price;
	
	@OneToOne
	@JoinColumn(name = "productID", nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "orderID", nullable = false)
	private Order order;

	public Long getOrderItemID() {
		return orderItemID;
	}

	public void setOrderItemID(Long orderItemID) {
		this.orderItemID = orderItemID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
