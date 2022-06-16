package com.revature.models;
/*
 *  connects orders to purchase products
 */
public class conn_order_product {
	private int id;
	private int order_id;
	private int product_id;
	private float offer_price;	
	private float remain_payments;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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
	public float getRemain_payments() {
		return remain_payments;
	}
	public void setRemain_payments(float remain_payments) {
		this.remain_payments = remain_payments;
	}

}
