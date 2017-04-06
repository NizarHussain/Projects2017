package com.vendingMachine.test_cases;

import java.util.ArrayList;
import java.util.List;

import com.vendingMachine.model.Coin;


public class VendingMachine {

	private List<Coin> listOfCoins = new ArrayList<Coin>();
	
	public String addCoins(String coinName,String coinAmount){
		Coin coin = new Coin();
		coin.setCoinName(coinName);
		coin.setCoinAmount(coinAmount);
		if(!coinName.equals("")&& !coinName.equals("pennies"))
		{
			listOfCoins.add(coin);
			return "true";
		}
		else if(coinName.equals("pennies")){
				System.out.println("Pennies Coin is Rejected............");
				return "false";
			 }
			 else{
				System.out.println("INSERT COIN........");
				return "INSERT COIN";
			 }
	}
	
	public String testExactChangeOnly(String productName, String productAmount,String inAmount){
		
		double prodAmount = Double.parseDouble(productAmount);
		double inputAmount = Double.parseDouble(inAmount);
		
		if(prodAmount==inputAmount)
			  return "true";
			else{
				
				return "false";
				
			}
				
	}
	
	
public String testMakeChange(String productName, String productAmount,String inAmount1,String inAmount2){
		
		double prodAmount = Double.parseDouble(productAmount);
		double inputAmount1 = Double.parseDouble(inAmount1);
		double inputAmount2 = Double.parseDouble(inAmount2);
		
		if(prodAmount==inputAmount1)
			  return "true";
			else{
				if((inputAmount1+inputAmount2)==prodAmount)
				return "false";
				
			}
		return "true";
				
	}

public String testReturnCoin(String productName, String productAmount,String inAmount1){
	
	double prodAmount = Double.parseDouble(productAmount);
	double inputAmount1 = Double.parseDouble(inAmount1);
	
	Double difference = inputAmount1-prodAmount;
	return difference.toString();
			
}


public String testSelectProduct(String productName, String productAmount,String inAmount1){
	
	double prodAmount = Double.parseDouble(productAmount);
	double inputAmount1 = Double.parseDouble(inAmount1);
	
	if(inputAmount1==prodAmount)
		  return "true";
		else{
			return "false";
			
		}
			
}


public String testSoldOut(String productName, String productAmount,String inAmount1,String inAmount2){
	
	double prodAmount = Double.parseDouble(productAmount);
	double inputAmount1 = Double.parseDouble(inAmount1);
	double inputAmount2 = Double.parseDouble(inAmount2);
	
	if(inputAmount1==prodAmount)
		  return "true";
		else{
			
			if((inputAmount1+inputAmount2)==prodAmount)
			return "true";
			
		}
			return "false";
}


}
