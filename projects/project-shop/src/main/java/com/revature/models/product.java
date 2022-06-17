package com.revature.models;

 
public class product {
	private int id;
	private String product_name;
	private float price;
	private float offer_price;		
	private float paid;	
	private int paid_status;	
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
	public float getOffer_price() {
		return offer_price;
	}
	public void setOffer_price(float offer_price) {
		this.offer_price = offer_price;
	}
	public float getPaid() {
		return paid;
	}
	public void setPaid(float paid) {
		this.paid = paid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPaid_status() {
		return paid_status;
	}
	public void setPaid_status(int paid_status) {
		this.paid_status = paid_status;
	}


	
}
