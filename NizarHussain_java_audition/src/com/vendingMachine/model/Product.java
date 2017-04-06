package com.vendingMachine.model;

public class Product {

	private String productName;
	private String productPrice;
	private String productCode;
	
	public Product(String productName,String productPrice){
		this.productName=productName;
		this.productPrice=productPrice;
	}
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productPrice="
				+ productPrice + "]";
	}

	
	
	
}
