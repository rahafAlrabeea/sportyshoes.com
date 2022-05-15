package com.sportshoes.models;

public class Orders {
	private int order_id;
	private String date;
	private int product_id;
	private int user_id;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Orders() {

	}

	public Orders(int order_id, String date, int product_id, int user_id) {
		super();
		this.order_id = order_id;
		this.date = date;
		this.product_id = product_id;
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", date=" + date + ", product_id=" + product_id + ", user_id=" + user_id
				+ "]";
	}

}
