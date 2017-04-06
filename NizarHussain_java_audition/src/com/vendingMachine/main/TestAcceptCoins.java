package com.vendingMachine.main;

import com.vendingMachine.model.Coin;

public class TestAcceptCoins {
	public static void main(String[] args) {

		VendingMachine vendingMachine = new VendingMachine();
			
		System.out.println(vendingMachine.addCoins(new Coin("nickels","100")));
		System.out.println(vendingMachine.addCoins(new Coin("dimes","200")));
		System.out.println(vendingMachine.addCoins(new Coin("quarters","300")));
		System.out.println(vendingMachine.addCoins(new Coin("pennies","100")));
		System.out.println(vendingMachine.addCoins(new Coin("","100")));
		
		
		
	}

}
