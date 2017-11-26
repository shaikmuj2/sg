package com.sg.discount.pojo;

public class Brand {

	private String name;
	public Brand(String string, Discount discount2) {
		this.name=string;
		this.discount=discount2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	private Discount discount ;
	
	
}
