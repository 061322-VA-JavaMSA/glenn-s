package com.revature.models;

public class offer {
	private int id;
	private int user_id;
	private int product_id;
	private float offer_price;	
	private int status;	
 	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public float getOffer_price() {
		return offer_price;
	}
	public void setOffer_price(float offer_price) {
		this.offer_price = offer_price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
 
	
}
