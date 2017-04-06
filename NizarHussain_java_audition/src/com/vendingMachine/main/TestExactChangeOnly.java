package com.vendingMachine.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.vendingMachine.model.Product;

public class TestExactChangeOnly {
	public static void main(String[] args) {

		Map<Integer,Product> productMap = new HashMap<Integer,Product>();
		productMap.put(1,new Product("Cola","1.00"));
		productMap.put(2,new Product("Chips","0.50"));
		productMap.put(3,new Product("Candy","0.65"));
		
		
		Scanner sc = new Scanner(System.in);
		int choice;
		do{
			System.out.println("1. COLA");
			System.out.println("2. CHIPS");
			System.out.println("3. CANDY");
			System.out.print("Enter Your Choice : ");
			choice = sc.nextInt();
			
			Product p = (Product)productMap.get(choice);
			System.out.print("Insert Money : ");
			double insertMoney = sc.nextDouble();
			double tempInsertMoney = insertMoney;
			double actualPrice = Float.parseFloat(p.getProductPrice());
			if(insertMoney==actualPrice)
			  System.out.println("Thank You.......for purchasing : "+p.getProductName().toUpperCase());
			else{
				
				System.out.println("EXACT CHANGE ONLY........");
				
			}
			  
		}while(choice==1 || choice==2 || choice==3);

	}

}
