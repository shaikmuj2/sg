package com.sg.discount.pojo;

public class Discount {

	public Discount(int i, String string) {
		this.discountPercentage = i;
		this.Desc = string;
	}
	public int getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	private int discountPercentage;
	private String Desc;
}
