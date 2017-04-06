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
public class TestReturnCoin {

	private String productName;
	private String productAmount;
	private String inputAmount1;
	
	private String expected;
	
	private VendingMachine vendingMachine;
	
	public TestReturnCoin(String expected,String productName,String productAmount,String inputAmount1){
		this.productName=productName;
		this.productAmount=productAmount;
		this.inputAmount1=inputAmount1;
		this.expected = expected;
	}
	@Before
	public void setTear(){
		vendingMachine = new VendingMachine();
	}
	
	@Parameters
	public static Collection<String[]> addedNumbers() {
	     return Arrays.asList(new String[][] {{"0.0","Cola","1.00","1.00"},{"0.5","Chips","0.50","1.00"}});
	}

	
	@Test
	public void addCoins()
	{		
		assertEquals(expected,vendingMachine.testReturnCoin(productName, productAmount,inputAmount1));
	}
}
