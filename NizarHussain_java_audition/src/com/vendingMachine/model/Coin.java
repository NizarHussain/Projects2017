package com.vendingMachine.model;

public class Coin {

	private String coinName;
	private String coinAmount;
	
	public Coin(){
		
	}
	public Coin(String coinName,String coinAmount){
		this.coinName=coinName;
		this.coinAmount=coinAmount;
	}
	public String getCoinName() {
		return coinName;
	}
	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}
	public String getCoinAmount() {
		return coinAmount;
	}
	public void setCoinAmount(String coinAmount) {
		this.coinAmount = coinAmount;
	}
}
