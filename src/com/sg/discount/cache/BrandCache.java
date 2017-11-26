package com.sg.discount.cache;
import java.util.HashMap;
import java.util.Map;

import com.sg.discount.pojo.Brand;
import com.sg.discount.pojo.Discount;

public class BrandCache {
	
	private Map<String,Brand> brandCache;
	
	public BrandCache() {
brandCache = new HashMap<String,Brand>();
	}
	public void buildBrandCache()
	{
	 brandCache.put("Wrangler", new Brand("Wrangler", new Discount(20,"Random Discount")));
	 brandCache.put("Arrow", new Brand("Arrow", new Discount(10,"Random Discount")));
	 brandCache.put("Adidas", new Brand("Adidas", new Discount(15,"Random Discount")));
	}
	public Brand getBrand(String string) {
		// TODO Auto-generated method stub
		return brandCache.get(string);
	}
	

	
}
