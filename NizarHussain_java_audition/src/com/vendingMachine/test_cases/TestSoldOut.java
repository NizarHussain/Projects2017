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
public class TestSoldOut {

	private String productName;
	private String productAmount;
	private String inputAmount1;
	private String inputAmount2;
	private String expected;
	
	private VendingMachine vendingMachine;
	
	public TestSoldOut(String expected,String productName,String productAmount,String inputAmount1,String inputAmount2){
		this.productName=productName;
		this.productAmount=productAmount;
		this.inputAmount1=inputAmount1;
		this.inputAmount2=inputAmount2;
		this.expected = expected;
	}
	@Before
	public void setTear(){
		vendingMachine = new VendingMachine();
	}
	
	@Parameters
	public static Collection<String[]> addedNumbers() {
	     return Arrays.asList(new String[][] {{"true","Cola","1.00","1.00","0.00"},{"true","Chips","0.50","0.25","0.25"}});
	}

	
	@Test
	public void addCoins()
	{		
		assertEquals(expected,vendingMachine.testSoldOut(productName, productAmount,inputAmount1,inputAmount2));
	}
}
