package com.gl.caseStudy2;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;



public class Main {

	private static String floatToString(double value) {
		DecimalFormat df = new DecimalFormat("0.00");
	    String val=df.format(value);
	    return val;  
	}
	public static String salesTaxCalculation(double billAmount) {
		  double taxAmount = 0.0;
	        if (billAmount <= 1000) {
	            taxAmount = billAmount * 0.125;
	        } else if (billAmount > 1000 && billAmount <= 2500) {
	            taxAmount = billAmount * 0.10;
	        } else {
	            taxAmount = billAmount * 0.075;
	        }
	        String tax = floatToString(taxAmount);
	        return tax;
	}
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Customer Name:");
		String customername=sc.nextLine();
		System.out.println("Enter number of items the customer purchases:");
		int n=Integer.parseInt(sc.nextLine());
		List<OrderedItem> orderedItemList=new ArrayList<>();
		
		for (int i=0;i<n;i++) {
			System.out.println("Enter name and quantity (comma separate format) of purchased item no "+(i+1));
			String str=sc.nextLine();
			String[] item = str.split(",");
			String itemname=item[0];
			String itemqty=item[1];
			if (ItemData.isAvailable(itemname)) {
				SnackItem s=ItemData.getItem(itemname);
				String rate=s.getRate();
				String discountRate=s.getDiscountRate();
				String discountQty=s.getDiscountQty();
				Double discountAmount=0.0;
				Double payAmount=Double.parseDouble(rate)*Double.parseDouble(itemqty);
				
				if (Double.parseDouble(itemqty)>=Double.parseDouble(discountQty)) {
					
					discountAmount=payAmount * (Double.parseDouble(discountRate)/100);
					payAmount= payAmount-discountAmount;
				}

				OrderedItem ordItem=new OrderedItem(itemname,rate,itemqty,floatToString(discountAmount),floatToString(payAmount) );
				orderedItemList.add(ordItem);	
			}//end of if
			
			else {
				System.out.println("Entered Item is not Available");
			}
			
		}//end of for
		DateFormat formatter = new SimpleDateFormat("dd-MM-yy");
		Calendar obj = Calendar.getInstance();
		String date = formatter.format(obj.getTime());
		System.out.println("\nCustomer Name:"+customername+"\t\t\tDate:"+date);
		
		String output=String.format("%-10s %-10s %-10s %-10s %-10s %-10s", "ITEM" ,"RATE","QUANTITY","PRICE","DISCOUNT","AMOUNT");
		System.out.println(output);
		Double billAmount=0.0;
		for (OrderedItem i:orderedItemList) {
			String name=i.getItemName();
			String rate=i.getRate();
			String qty=i.getOrderQty();
			SnackItem snack=ItemData.getItem(name);
			Double price=Double.parseDouble(snack.getRate())*Double.parseDouble(qty);
			String discamnt=i.getDiscountAmount();
			String amount=i.getPayAmount();
			billAmount+= Double.parseDouble(amount);
			String op=String.format("%-10s %-10s %-10s %-10s %-10s %-10s", name,rate,qty,price,discamnt,amount);
			System.out.println(op);
		}
		String tax=salesTaxCalculation(billAmount);
		Double total=billAmount+Double.parseDouble(tax);
		
		System.out.println("\n\t\t\t\tBill Amount:"+billAmount);
		System.out.println("\t\t\t\tAdd: Sales Tax:"+tax);
		System.out.println("\t\t\t\tFinal Amount:"+total);
	
		
	}

}