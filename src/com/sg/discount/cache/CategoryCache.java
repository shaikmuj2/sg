package com.sg.discount.cache;

import java.util.Map;

import com.sg.discount.pojo.Category;
import com.sg.discount.pojo.Discount;

 public class  CategoryCache {
	private  Map<String,Category> categoryCache;
	
	public  void buildCache()
	{
		categoryCache.put("MensWear",new Category("MensWear",null,null) );
		categoryCache.put("Shirt",new Category("Shirt", categoryCache.get("MensWear"),null) );
		categoryCache.put("Trousers",new Category("Trousers", categoryCache.get("MensWear"),null) );
		categoryCache.put("Casuals",new Category("Casuals", categoryCache.get("MensWear"),null) );
		categoryCache.put("Jeans",new Category("Casuals", categoryCache.get("MensWear"),null) );
		
		categoryCache.put("Womenswear",new Category("Womenswear",null,null) );
		categoryCache.put("Dresses",new Category("Dresses", categoryCache.get("Womenswear"),null) );
		categoryCache.put("Shirt",new Category("Footwear", categoryCache.get("Womenswear"),null) );
		
	}
	
	

	public  Category getCategory(String string) {
		// TODO Auto-generated method stub
		return categoryCache.get(string);
	}
	
	
}
