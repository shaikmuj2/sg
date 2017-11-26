package com.sg.discount;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.sg.discount.strategy.DiscountStrategyInterface;
import com.sg.discount.strategy.HierarchyDiscountStratgey;

public class DiscountMain {
public static void main(String[] args) throws Exception
{
	if(args.length == 0)
		throw new Exception("no arguments paased");
	String path = args[0];
    
    File inventoryAndCartInputFile  = new File(path);
    DiscountStrategyInterface hierarchyDiscountStratgey = new HierarchyDiscountStratgey();
    DiscountClient discountClient = new DiscountClient();
    discountClient.initializeCache();
    try {
		discountClient.parseInputFile(inventoryAndCartInputFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("DiscountMain.main() File Parse Error");
	}
    
	List<Integer> priceList = discountClient.processDiscount(hierarchyDiscountStratgey);
	priceList.forEach(val-> System.out.println("Discount Value "+ val));
	
}
}
