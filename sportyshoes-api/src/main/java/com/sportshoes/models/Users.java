package com.sportshoes.models;

public class Users {
	private int user_id;
	private String full_name;
	private String password;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Users() {

	}

	public Users(int user_id, String full_name, String password) {
		super();
		this.user_id = user_id;
		this.full_name = full_name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", full_name=" + full_name + ", password="
				+ password + "]";
	}

}
