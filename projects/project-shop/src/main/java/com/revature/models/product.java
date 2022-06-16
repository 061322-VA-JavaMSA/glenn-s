package com.revature.models;

 
//using is_active 0 or 1 rather than deleting
public class product {
	private int id;
	private String product_name;
	private float price;
	private float offer_price;		
	private boolean active;
	private float remain_payments;	
	private int user_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}


	
}
