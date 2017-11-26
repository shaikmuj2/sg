package com.sg.discount.strategy;

import java.util.List;


import com.sg.discount.pojo.Category;
import com.sg.discount.pojo.Item;

public class HierarchyDiscountStratgey implements DiscountStrategyInterface{

	@Override
	public Integer compute(List<Item> items) {
		Integer itemsVal=0;
		for (Item item : items) {
			int discountPercentage = computeMaxOfDiscounts(item);
			itemsVal = itemsVal + item.getPrice()*(1/discountPercentage);
		}
		return itemsVal;
	}

	private int computeMaxOfDiscounts(Item item) {
	
		int discountPercentage = 0;	
		if(item.getBrand().getDiscount().getDiscountPercentage()  > item.getDiscount().getDiscountPercentage())
			discountPercentage = 	item.getBrand().getDiscount().getDiscountPercentage();
		else 
			discountPercentage= item.getDiscount().getDiscountPercentage();
		
		
		return computeMaxofCategoryDiscount(item.getCategory(),discountPercentage) ;
	}

	private int computeMaxofCategoryDiscount(Category category, int discountPercentage) {
		if(category.getParent()== null)
			return (discountPercentage>category.getDiscount().getDiscountPercentage())?discountPercentage: category.getDiscount().getDiscountPercentage();
	
		int recurssionmaxVal = computeMaxofCategoryDiscount(category.getParent(),category.getDiscount().getDiscountPercentage());
	 return  (recurssionmaxVal>discountPercentage)?recurssionmaxVal: discountPercentage;
	}



}
