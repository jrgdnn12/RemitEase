package edu.unlv.mis768.labwork18;

/**
 * This class represents a customer record.
 * @author Han-fen Hu
 * @version 1.0
 */

public class Customer {
	//Fields
	String cusNo;
	String cusName;
	String cusAddress;
	String cusCity;
	String cusState;
	String cusZip;
	
	//Constructors
	/**
	 * No-arg constructor
	 */
	public Customer (){
		
	}
	
	/**
	 * Constructor with every fields
	 * @param cNo Customer number
	 * @param cName Customer name
	 * @param cAddress Street address
	 * @param cCity City
	 * @param cSate State
	 * @param cZip Zip
	 */
	public Customer(String cNo, String cName, String cAddress, String cCity, String cSate, String cZip) {
		super();
		cusNo = cNo;
		cusName = cName;
		cusAddress = cAddress;
		cusCity = cCity;
		cusState = cSate;
		cusZip = cZip;
	}

	// All the getters
	public String getCusNo() {
		return cusNo;
	}

	public String getCusName() {
		return cusName;
	}

	public String getCusAddress() {
		return cusAddress;
	}

	public String getCusCity() {
		return cusCity;
	}

	public String getCusState() {
		return cusState;
	}

	public String getCusZip() {
		return cusZip;
	}

	// All the setters
	public void setCusNo(String cusNo) {
		this.cusNo = cusNo;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public void setCusCity(String cusCity) {
		this.cusCity = cusCity;
	}

	public void setCusState(String cusState) {
		this.cusState = cusState;
	}

	public void setCusZip(String cusZip) {
		this.cusZip = cusZip;
	}
	
	public String toString() {
		return cusNo+","+cusName;
	}

}
