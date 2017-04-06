package com.vendingMachine.test_cases;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.vendingMachine.test_cases.VendingMachine;

@RunWith(Parameterized.class)
public class TestAcceptCoins {

	private String coinName;
	private String coinAmount;
	private String expected;
	static private Integer finalAmount = 0;
	private VendingMachine vendingMachine;
	
	public TestAcceptCoins(String expected,String coinName,String coinAmount){
		this.expected=expected;
		this.coinName=coinName;
		this.coinAmount = coinAmount;
	}
	@Before
	public void setTear(){
		vendingMachine = new VendingMachine();
	}
	
	@Parameters
	public static Collection<String[]> addedNumbers() {
	     return Arrays.asList(new String[][] {{"true","nickels","100"},{"true","dimes","200"},{"true","quarters","300"},{"false","pennies","100"},{"INSERT COIN","","100"}});
	}

	
	@Test
	public void addCoins()
	{
		if(!coinName.equals("")&& !coinName.equals("pennies"))
			finalAmount+=Integer.parseInt(coinAmount);
		System.out.println(" Coin Name -----> "+coinName);
		assertEquals(expected,vendingMachine.addCoins(coinName, coinAmount));
		System.out.println("The Final Amount is : "+finalAmount);
	}
}
