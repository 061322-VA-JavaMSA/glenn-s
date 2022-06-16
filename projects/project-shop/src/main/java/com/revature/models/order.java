package com.revature.models;

import java.time.LocalDate;

public class order {
	private int id;
	private int user_id;
	private double order_total;
	private LocalDate order_date;
	private boolean is_aceept;
	
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
	public double getOrder_total() {
		return order_total;
	}
	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}
	public LocalDate getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	public boolean isIs_aceept() {
		return is_aceept;
	}
	public void setIs_aceept(boolean is_aceept) {
		this.is_aceept = is_aceept;
	}

}
