package com.sportshoes.models;

public class Products {
	private int product_id; 
	private String product_name;
	
	private double MSRP; 
	private int quantity_instock;
	private String product_vendor;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getMSRP() {
		return MSRP;
	}
	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}
	public int getQuantity_instock() {
		return quantity_instock;
	}
	public void setQuantity_instock(int quantity_instock) {
		this.quantity_instock = quantity_instock;
	}
	public String getProduct_vendor() {
		return product_vendor;
	}
	public void setProduct_vendor(String product_vendor) {
		this.product_vendor = product_vendor;
	}
	
	public Products()
	{
		
	}
	public Products(int product_id, String product_name, double mSRP, int quantity_instock,
			String product_vendor) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.MSRP = mSRP;
		this.quantity_instock = quantity_instock;
		this.product_vendor = product_vendor;
	}
	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", MSRP=" + MSRP + ", quantity_instock=" + quantity_instock + ", product_vendor=" + product_vendor
				+ "]";
	}
	
}
