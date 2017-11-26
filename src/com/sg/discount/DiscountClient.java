package com.sg.discount;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.sg.discount.cache.BrandCache;
import com.sg.discount.cache.CategoryCache;
import com.sg.discount.pojo.Item;
import com.sg.discount.strategy.DiscountStrategyInterface;

public class DiscountClient {
	 private List<List<Item>> userCartLists ;
	 private Inventory inventory;
	 private BrandCache brandCache;
	 private CategoryCache categoryCache;
	 
	 
	private DiscountHelper discountHelper;
public DiscountClient() {
	userCartLists = new ArrayList<>();
	inventory = new Inventory();
	
	 
}
	
	public void parseInputFile(File userInputFile) throws IOException
	{
		
		FileInputStream fis = null;
		fis = new FileInputStream(userInputFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		//Create Inventory
	 inventory = discountHelper.parseAndCreateInvntory(br);
	 userCartLists = 	 discountHelper.parseUserItemSelection(br,inventory);
	}

	public List<Integer> processDiscount(DiscountStrategyInterface hierarchyDiscountStratgey) {
		// TODO Auto-generated method stub
		List<Integer> priceList = new ArrayList<>();
		for (List<Item> list : userCartLists) {
			
			priceList.add(hierarchyDiscountStratgey.compute(list));
		}
		return priceList;
	}

	public void initializeCache() {
		brandCache = new BrandCache();
		brandCache.buildBrandCache();
		categoryCache = new CategoryCache();
		categoryCache.buildCache();
		
	}

}
