package edu.unlv.mis768.labwork9;

public class Stock {
	//field
	private String symbol;
	private double sharePrice;
	
	//Constructor
	public Stock(String sym, double price){
		symbol = sym;
		sharePrice = price;
	}

	//getters and setters
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	// copy method
	
	
	// toString method

	
	// overwrite the equals method
	

}
