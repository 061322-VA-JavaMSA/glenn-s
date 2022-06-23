package com.revature.models;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public class Product {
	private int id;
	private String product_name;
	private double price;
	private double offer_price;		
	private double paid;	
	private int paid_status;
	private Timestamp paid_at;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getOffer_price() {
		return offer_price;
	}
	public void setOffer_price(double offer_price) {
		this.offer_price = offer_price;
	}
	public double getPaid() {
		return paid;
	}
	public void setPaid(double paid) {
		this.paid = paid;
	}
	public int getPaid_status() {
		return paid_status;
	}
	public void setPaid_status(int paid_status) {
		this.paid_status = paid_status;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Timestamp getPaid_at() {
		return paid_at;
	}
	public void setPaid_at(Timestamp paid_at) {
		this.paid_at = paid_at;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, offer_price, paid, paid_at, paid_status, price, product_name, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id && Double.doubleToLongBits(offer_price) == Double.doubleToLongBits(other.offer_price)
				&& Double.doubleToLongBits(paid) == Double.doubleToLongBits(other.paid)
				&& Objects.equals(paid_at, other.paid_at) && paid_status == other.paid_status
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(product_name, other.product_name) && user_id == other.user_id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", price=" + price + ", offer_price="
				+ offer_price + ", paid=" + paid + ", paid_status=" + paid_status + ", paid_at=" + paid_at
				+ ", user_id=" + user_id + "]";
	}
 
	 
	 

	
}
