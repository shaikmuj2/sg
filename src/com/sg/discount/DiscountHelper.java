package com.sg.discount;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sg.discount.cache.BrandCache;
import com.sg.discount.cache.CategoryCache;
import com.sg.discount.pojo.Item;

public class DiscountHelper {
	
	private BrandCache brandCache;
	private CategoryCache categoryCache;

	public DiscountHelper(BrandCache brandCache,CategoryCache categoryCache) {
		this.brandCache = brandCache;
		this.categoryCache = categoryCache;
	}
	
	
	public Inventory parseAndCreateInvntory(BufferedReader br) throws NumberFormatException, IOException {
        Integer noOfInventoryItems = Integer.parseInt(br.readLine());
        Inventory inventory = new Inventory();
        
        for(int i = 0; i< noOfInventoryItems;i++)
        {
        	String line = br.readLine().trim();
        	if(line!=null)
        		inventory.addItem(preapreInventroyItem(br.readLine()));
        }
        
		return inventory;
	}

	private Item preapreInventroyItem(String readLine) {
	// read 	1, Arrow,Shirts,800 into item object
		String[] values = readLine.split(",");
		return new Item(Integer.parseInt(values[0]),brandCache.getBrand(values[1]), categoryCache.getCategory(values[2]),Integer.parseInt(values[3]));
		
	}

	public List<List<Item>> parseUserItemSelection(BufferedReader br,Inventory inventory) throws NumberFormatException, IOException {
	
	        Integer noOfCusotmerItems = Integer.parseInt(br.readLine().trim());
			        
	        List<List<Item>> customerCartItems = new ArrayList<>();
	        
	        for(int i = 0; i< noOfCusotmerItems;i++)
	        {
	        	String line = br.readLine();
	        	customerCartItems.add(processCustomerItems(line,inventory));		
		}
		
	        return customerCartItems;
	}


	private List<Item> processCustomerItems(String line,Inventory inventory) {
		// TODO Auto-generated method stub
		List<Item> userCartList = new ArrayList<>();
		String[] values = line.split(",");
		for (String string : values) {
			userCartList.add(inventory.getItemByID(Integer.parseInt(string)));
		}
		return userCartList;
	}
}
