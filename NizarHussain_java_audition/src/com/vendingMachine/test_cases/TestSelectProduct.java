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
public class TestSelectProduct {

	private String productName;
	private String productAmount;
	private String inputAmount1;
	
	private String expected;
	
	private VendingMachine vendingMachine;
	
	public TestSelectProduct(String expected,String productName,String productAmount,String inputAmount1){
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
	     return Arrays.asList(new String[][] {{"true","Cola","1.00","1.00"},{"false","Chips","0.50","0.25"}});
	}

	
	@Test
	public void addCoins()
	{		
		assertEquals(expected,vendingMachine.testSelectProduct(productName, productAmount,inputAmount1));
	}
}
