package com.gl.caseStudy2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ItemData {
	public static  Map<String,SnackItem> getAllItems(){
		return itemMap;
	}
	
	public static SnackItem getItem(String itemName) {
		SnackItem snacks=itemMap.get(itemName);
		return snacks;
	}
	
	public static boolean isAvailable(String itemName) {
		return itemMap.containsKey(itemName);
	}
	
	private static Map<String,SnackItem> itemMap= new HashMap<>();
	static {
		
	try {
		FileReader fileReader=new FileReader("D://GlobalLogic//CaseStudies//SnackItem.txt");
		BufferedReader bReader= new BufferedReader(fileReader);
		while (true) {
			String str=bReader.readLine();
			if (str==null)
				break;
			String[] arr = str.split("-");
			String status=arr[2];
			if (status.equals("N")) {
				continue;
			}
			
			String name=arr[0];
			String rate=arr[1];
			String discountRate =arr[3];
			String discountQty =arr[4];
			
			SnackItem snack=new SnackItem(name,rate,status,discountRate,discountQty);
			itemMap.put(name,snack);
		}
		
		bReader.close();
		fileReader.close();
	} catch (Exception e) {}
	
	
	}
	
	
}
