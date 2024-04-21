package edu.unlv.mis768.labwork7;

public class OrderDetail {
	// field
	private int quantity;
	private Product item;
	
	// no-arg constructor
	public OrderDetail() {}
	
	// parameterized constructor
	public OrderDetail(int qty, Product item) {
		quantity = qty;
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getItem() {
		return item;
	}

	public void setItem(Product item) {
		this.item = item;
	}
	
	public double getSubtotal() {
		return quantity * item.getUnitPrice();
	}
	
	public double calcTax() {
		double taxAmount=0;
		
		if(!item.getType().equalsIgnoreCase("food"))
			taxAmount = getSubtotal()*0.06;
		
		return taxAmount;
					
	}
}
