package com.revature.models;

 
public class product {
	private int id;
	private String product_name;
	private float price;
	private float offer_price;		
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
	public float getOffer_price() {
		return offer_price;
	}
	public void setOffer_price(float offer_price) {
		this.offer_price = offer_price;
	}
	public float getRemain_payments() {
		return remain_payments;
	}
	public void setRemain_payments(float remain_payments) {
		this.remain_payments = remain_payments;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	
}
