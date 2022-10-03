package com.gl.caseStudy2;

public class SnackItem {

	private String itemName;
	private String rate;
	private String status;
	private String discountRate; 
	private String discountQty;
	
	public SnackItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SnackItem(String itemName, String rate, String status, String discountRate, String discountQty) {
		super();
		this.itemName = itemName;
		this.rate = rate;
		this.status = status;
		this.discountRate = discountRate;
		this.discountQty = discountQty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
	}

	public String getDiscountQty() {
		return discountQty;
	}

	public void setDiscountQty(String discountQty) {
		this.discountQty = discountQty;
	}
	
	
	
}
