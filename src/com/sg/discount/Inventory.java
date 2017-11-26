package com.sg.discount;

import java.util.List;

import com.sg.discount.pojo.Item;

public final class Inventory {
	
	private static int id;
	List<Item> items;
	
	public Inventory() {
		id=0;
	}
	
	public int addItem(Item item)
	{
		
	//item.setId(++id);
	  items.	add(item);
	  return id;
	}
	
	public  Item getItemByID(int id)
	{
		return items.stream().filter(item -> (item.getId()== id)).findAny().orElse(null);
	}	
	
}
