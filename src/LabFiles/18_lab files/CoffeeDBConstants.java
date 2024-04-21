package edu.unlv.mis768.labwork18;
/**
 * This class defines the strings used to establish a database connection
 *
 */
public final class CoffeeDBConstants {
	static public final String DB_URL = "jdbc:mysql://localhost:3306/coffeeShopData";
    static public final String USER_NAME = "root";
    static public final String PASSWORD = "";
    static public final String CUSTOMER_TABLE_NAME  = "customer";
    static public final String CUSTOMER_PK_NAME = "CustomerNumber";
    static public final String COFFEE_TABLE_NAME  = "coffee";
    static public final String COFFEE_PK_NAME = "ProdNum";


}
