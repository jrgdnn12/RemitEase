package edu.unlv.mis768.labwork16;
/**
 * The SavingsAccount class stores data about a savings account
 * @author Han-fen Hu
 * @version 2.0
 *
 */
public class SavingsAccount {
	private double balance;				// The account balance
	private double interestRate;		// The monthly interest rate
	
	/**
	 * The constructor initializes an object with a balance 
	 * @param bal The starting balance of the account
	 */
	public SavingsAccount(double bal) {
		this.balance = bal;
	}
	
	/**
	 * The constructor initializes an object
	 */
	public SavingsAccount(){
		this.balance = 0;
	}
	
	/**
	 * The getBalance method returns the current balance of the account
	 * @return balance The account balance
	 */
	public double getBalance() {
		return balance;
	}

	/** 
	 * The setBalance method sets the balance of the account.
	 * @param balance The account balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * The getInterestRate method returns the current interest rate
	 * @return The interest Rate
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * The setInterestRate method sets the interest rate for the account.
	 * @param interestRate The monthly interest rate
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	
	/**
	 * The withdraw method withdraws an amount from the account.
	 * @param amount The amount to withdraw.
	 */
	public void withdraw(double amount){
		balance = balance - amount;
	}
	
	/**
	 * The deposit method deposits an amount into the account.
	 * @param amount The amount to deposit.
	 */
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	/**
	 * The addInterest method calculates the monthly interest 
	 * and adds it to the account balance.
	 */
	public void addInterest(){
		balance = balance * (1+ interestRate);
	}


}
