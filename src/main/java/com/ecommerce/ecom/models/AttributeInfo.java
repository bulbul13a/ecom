package com.ecommerce.ecom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "attribute_info")
public class AttributeInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long attributeid;
	
	@Column(name ="attributeName")
	private String attributeName;
	
	@Column(name = "attributeValue")
	private String attributeValue;
	
	@ManyToOne
	@JoinColumn(name = "productID", nullable = false)
	private Product product;

	public Long getAttributeid() {
		return attributeid;
	}

	public void setAttributeid(Long attributeid) {
		this.attributeid = attributeid;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
