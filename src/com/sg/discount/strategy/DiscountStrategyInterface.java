package com.sg.discount.strategy;

import java.util.List;

import com.sg.discount.pojo.Item;

public interface DiscountStrategyInterface {

	Integer compute(List<Item> item);
	
}
