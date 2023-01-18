package com.pojo;

public class Product {
	//productId | prodName     | company | price  |
	private int productId;
	private String  prodName;
	private String company;
	private double price;
	
	
	public Product(int productId, String prodName, String company, double price) {
		super();
		this.productId = productId;
		this.prodName = prodName;
		this.company = company;
		this.price = price;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", prodName=" + prodName + ", company=" + company + ", price="
				+ price + "]";
	}
	
	
	
	
	

}
