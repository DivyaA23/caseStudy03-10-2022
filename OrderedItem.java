package com.gl.caseStudy2;
public class OrderedItem {
	private String itemName;
	private String rate;
	private String orderQty;
	private String discountAmount;
	private String payAmount;
	
	public OrderedItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderedItem(String itemName, String rate, String orderQty, String discountAmount, String payAmount) {
		super();
		this.itemName = itemName;
		this.rate = rate;
		this.orderQty = orderQty;
		this.discountAmount = discountAmount;
		this.payAmount = payAmount;
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

	public String getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}

	public String getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}
	
	
	
}
