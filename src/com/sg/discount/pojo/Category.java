package com.sg.discount.pojo;

public class Category {
	
public Category(String categoryName,Category parent, Discount discount ) {
	this.categoryName= categoryName;
	this.parent = parent;
	this.discount = discount;
}
	
	String categoryName;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	private Category parent;
	private Discount discount;

}
