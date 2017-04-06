package com.vendingMachine.main;


import java.util.ArrayList;
import java.util.List;

import com.vendingMachine.model.Coin;


public class VendingMachine {

	 List<Coin> listOfCoins = new ArrayList<Coin>();
	
	public String addCoins(Coin coin){
		
		if(!coin.getCoinName().equals("")&& !coin.getCoinName().equals("pennies"))
		{
			listOfCoins.add(coin);
			return "Coin Added Successfully.......";
		}
		else if(coin.getCoinName().equals("pennies")){
				//System.out.println("Pennies Coin is Rejected............");
				return "Pennies Coin is Rejected............";
			 }
			 else{
				return "INSERT COIN";
			 }
	}
	
}
