package edu.unlv.mis768.labwork17;


import java.sql.*;   // Needed for JDBC classes

public class CreateDB {
	   public static void main(String[] args) {
	      // Create a named constant for the URL.
	      // NOTE: This value is specific for MySQL.
	      final String DB_URL = "jdbc:mysql://localhost:3306/";
	      final String DB_COFFEE_URL = "jdbc:mysql://localhost:3306/CoffeeShopData";
	      final String USERNAME = "root";
	      final String PASSWORD = "";
	      
	      try {
	         // Create a connection to the database.
	         Connection conn =
	                DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	            // Create the database. If the database already exists, drop it. 
	            createDataBase(conn);
	            conn.close();
	            
	         //Create a connection to the database and to the coffee database   
	         Connection conn2 =
	        		 DriverManager.getConnection(DB_COFFEE_URL, USERNAME, PASSWORD);
				
				// Build the Coffee table.
				buildCoffeeTable(conn2);
				
				// Build the Customer table.
				buildCustomerTable(conn2);
				
				// Build the UnpaidInvoice table.
				buildUnpaidOrderTable(conn2);

	         // Close the connection.
	         conn2.close();
	      } catch (Exception ex) {
	         System.out.println("ERROR: "+ ex.getMessage());
	      }
	   }

	   /**
	    * The createDatabase method creates the DB. If the DB is already existed, drop the DB first.
	    */
	   
	   public static void createDataBase(Connection conn) {
		   System.out.println("Checking for existing database.");
		   
		   try{
			   Statement stmt = conn.createStatement();
			   
			   //Drop the existing database
			   try {
				   stmt.executeUpdate("Drop DATABASE coffeeshopdata");
			   }
			   catch(SQLException ex) {
					// No need to report an error.
					// The database simply did not exist.
				}
			   //Create a new database
			   try {
				   stmt.execute("Create DATABASE coffeeshopdata");
				   //stmt.execute("USE coffee");
				   System.out.println("Database coffeeShopData created.");
			   }
			   catch(SQLException ex) {
					// No need to report an error.
					// The database simply did not exist.
				}			   
		   }
	  	   catch(SQLException ex) {
	  		   System.out.println("ERROR: "+ ex.getMessage());
	  		   ex.printStackTrace();
			}
	   }
		
		/**
		 * The buildCoffeeTable method creates the
		 * Coffee table and adds some rows to it.
		 */
		public static void buildCoffeeTable(Connection conn){
			try {
	         // Get a Statement object.
	         Statement stmt = conn.createStatement();
	         
				// Create the table.
				stmt.execute("CREATE TABLE Coffee ("+ 
	   				       "Description CHAR(25),"+  
	                       "ProdNum CHAR(10) NOT NULL PRIMARY KEY,"+  
	                       "Price DOUBLE)");
								 
				// Insert data
				stmt.execute("INSERT INTO Coffee VALUES ('Bolivian Dark', '14-001', 8.95)");
				stmt.execute("INSERT INTO Coffee VALUES ('Bolivian Medium', '14-002', 8.95 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Brazilian Dark', '15-001', 7.95 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Brazilian Medium', '15-002', 7.95 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Brazilian Decaf', '15-003', 8.55 )" );
				stmt.execute("INSERT INTO Coffee VALUES ('Central American Dark', '16-001', 9.95 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Central American Medium','16-002',9.95 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Sumatra Dark','17-001',7.95 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Sumatra Decaf','17-002',8.95 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Sumatra Medium','17-003',7.95 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Sumatra Organic Dark','17-004',11.95 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Kona Medium','18-001',18.45 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Kona Dark','18-002',18.45 )");
				stmt.execute("INSERT INTO Coffee VALUES ('French Roast Dark','19-001',9.65 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Galapagos Medium','20-001',6.85 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Guatemalan Dark','21-001',9.95 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Guatemalan Decaf','21-002',10.45 )");
				stmt.execute("INSERT INTO Coffee VALUES ('Guatemalan Medium','21-003',9.95 )");
				
				// confirmation message
				System.out.println("Coffee table created.");
			} catch (SQLException ex) {
	         System.out.println("ERROR: "+ex.getMessage());
			}
		}

		/**
		 * The buildCustomerTable method creates the
		 * Customer table and adds some rows to it.
		 */
		public static void buildCustomerTable(Connection conn){
	      try {
	         // Get a Statement object.
	         Statement stmt = conn.createStatement();
	         
	         // Create the table.
	         stmt.execute("CREATE TABLE Customer "+
	            "( CustomerNumber CHAR(10) NOT NULL PRIMARY KEY,"+
	            "  Name CHAR(25),"    +
	            "  Address CHAR(25), "+
	            "  City CHAR(12),"    +
	            "  State CHAR(2),"    +
	            "  Zip CHAR(5) )");

	         // Add some rows to the new table.
	         stmt.executeUpdate("INSERT INTO Customer VALUES ('101', 'Downtown Cafe', '17 N. Main Street', 'Asheville', 'NC', '55515')");
	         stmt.executeUpdate("INSERT INTO Customer VALUES ('102', 'Main Street Grocery', '110 E. Main Street', 'Canton', 'NC', '55555')");
	         stmt.executeUpdate("INSERT INTO Customer VALUES ('103', 'The Coffee Place', '101 Center Plaza', 'Waynesville', 'NC', '55516')");
	         stmt.executeUpdate("INSERT INTO Customer VALUES ('104', 'The Roster', '102 Center Plaza', 'Waynesville', 'NC', '55516')");
	         stmt.executeUpdate("INSERT INTO Customer VALUES ('105', 'Cooldown Place', '853 Younster Street', 'Asheville', 'NC', '55516')");	         

			 // confirmation message
			 System.out.println("Customer table created.");

		  } catch (SQLException ex) {
	         System.out.println("ERROR: "+ex.getMessage());
		  }
		}

		/**
		 * The buildUnpaidOrderTable method creates
		 * the UnpaidOrder table.
		 */

		public static void buildUnpaidOrderTable(Connection conn){
	      try {
	         // Get a Statement object.
	         Statement stmt = conn.createStatement();
				
	         // Create the table.
	         stmt.execute("CREATE TABLE UnpaidOrder"+
					"( CustomerNumber CHAR(10) NOT NULL REFERENCES Customer(CustomerNumber), "+
					"  ProdNum CHAR(10) NOT NULL REFERENCES Coffee(ProdNum),"+
					"  OrderDate CHAR(10),"+
					"  Quantity DOUBLE,"+
					"  Cost DOUBLE )");
					
	         stmt.executeUpdate("INSERT INTO unpaidorder VALUES ('101','15-003','2020-12-10',3,25.65);");
	         stmt.executeUpdate("INSERT INTO unpaidorder VALUES ('101','16-001','2020-12-10',1,9.95);");
	         stmt.executeUpdate("INSERT INTO unpaidorder VALUES ('101','16-002','2020-12-10',1,9.95);");
	         stmt.executeUpdate("INSERT INTO unpaidorder VALUES ('105','15-003','2021-03-10',3,25.65);");
	         stmt.executeUpdate("INSERT INTO unpaidorder VALUES ('104','20-001','2021-03-13',1,6.85);");
	         stmt.executeUpdate("INSERT INTO unpaidorder VALUES ('105','18-002','2021-03-20',1,18.45);");
	         stmt.executeUpdate("INSERT INTO unpaidorder VALUES ('103','17-001','2021-03-20',1,7.95);");
	         
				System.out.println("UnpaidOrder table created.");
			}
			catch (SQLException ex) {
	         System.out.println("ERROR: "+ex.getMessage());
			}
		}
}
