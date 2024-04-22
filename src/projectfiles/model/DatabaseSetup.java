package projectfiles.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    private static final String URL = "jdbc:mysql://remitease.cr2esock8dpy.us-west-2.rds.amazonaws.com:3306/RemitEaseDev?useSSL=false&serverTimezone=UTC";
    private static final String USER = "admin";
    private static final String PASSWORD = "rEmitEase$";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTables(conn);
            System.out.println("All tables created successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    


    private static void createTables(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
        	
            // Disable foreign key checks
            stmt.execute("SET FOREIGN_KEY_CHECKS = 0");

            // Drop tables
            stmt.execute("DROP TABLE IF EXISTS Remittance");
            stmt.execute("DROP TABLE IF EXISTS ExchangeRate");
            stmt.execute("DROP TABLE IF EXISTS Customer");
            stmt.execute("DROP TABLE IF EXISTS Recipient");
            stmt.execute("DROP TABLE IF EXISTS Partner");
            stmt.execute("DROP TABLE IF EXISTS User");

            // Re-enable foreign key checks
            stmt.execute("SET FOREIGN_KEY_CHECKS = 1");
            
            // User Table
            stmt.execute("CREATE TABLE IF NOT EXISTS User (" +
                         "UserId VARCHAR(255) PRIMARY KEY, " +
                         "Password VARCHAR(255) NOT NULL),;");
            
            //Insert into User's table
            stmt.execute("INSERT INTO User VALUES ('CSR100','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR101','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR103','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR104','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR105','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR106','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR107','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR108','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR109','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR110','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR111','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR112','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR113','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR114','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR115','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR116','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR117','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR118','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR119','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR120','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR121','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR122','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR123','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR124','1234')");
            stmt.execute("INSERT INTO User VALUES ('CSR125','1234')");
            stmt.execute("INSERT INTO User VALUES ('PRT100','7352')");
            stmt.execute("INSERT INTO User VALUES ('PRT101','7352')");
            stmt.execute("INSERT INTO User VALUES ('PRT102','7352')");
            stmt.execute("INSERT INTO User VALUES ('PRT103','7352')");
            stmt.execute("INSERT INTO User VALUES ('RCP100','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP101','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP102','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP103','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP104','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP105','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP106','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP107','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP108','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP109','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP110','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP111','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP112','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP113','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP114','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP115','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP116','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP117','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP118','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP119','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP120','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP121','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP122','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP123','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP124','5748')");
            stmt.execute("INSERT INTO User VALUES ('RCP125','5748')");
            
         // Customer Table
            stmt.execute("CREATE TABLE IF NOT EXISTS Customer (" +
                         "CustomerId VARCHAR(255) PRIMARY KEY, " +
                         "First_Name VARCHAR(255), " +
                         "Last_Name VARCHAR(255), " +
                         "PhoneNumber VARCHAR(255), " +
                         "Email VARCHAR(255), " +
                         "Balance DOUBLE, " +
                         "Country VARCHAR(255), " +
                         "City VARCHAR(255), " +
                         "Address VARCHAR(255), " +
                         "FOREIGN KEY (CustomerId) REFERENCES User(UserId));");
            
            // Insert into Customer's Table
            stmt.execute("INSERT INTO Customer VALUES ('CSR100','Bolivian','Dark','743-857-3982','boliviandark@gmail.com',600.00,'USA','Las Vegas','124 University Road')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR101','Andrew','Park','324-002-0943','andrewpark@gmail.com',600.00,'USA','Dallas','125 Boulevard Road')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR103','Janet','Princess','356-562-3423','janetprincess@gmail.com',600.00,'USA','San Francisco','126 School Road')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR104','Tobias','Prince','783-095-8323','tobiasprince@gmail.com',700.00,'USA','Athens','127 Pent Road')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR105','Emma','Phelps','645-394-8518','emmaphelps@gmail.com',700.00,'USA','Orlando','128 Vegas Road')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR106','Wonder','Fulton','746-859-2830','wonderfulton@gmail.com',700.00,'USA','Bronx','129 Tempe Road')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR107','Fred','Cumming','465-038-9481','fredcumming@gmail.com',700.00,'USA','Bozeman','543 Temple Street')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR108','Harry','Chris','783-092-0938','harrychris@gmail.com',700.00,'USA','Seattle','544 Market Street')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR109','Sam','Morris','567-057-7261','sammorris@gmail.com',700.00,'USA','Atlanta','545 Tropicana Street')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR110','Chester','Taylor','746-947-9473','chestertaylor@gmail.com',700.00,'USA','Los Angeles','546 Flaming Street')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR111','Gray','Pierce','647-097-9273','graypierce@gmail.com',700.00,'USA','Chicago','547 Jet Street')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR112','Stone','Beckley','756-084-7623','stonebeckley@gmail.com',900.00,'USA','Phoenix','548 Seth Street')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR113','Pearl','Watson','512-947-9363','pearlwatson@gmail.com',900.00,'USA','Houston','549 Bottle Road')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR114','Derry','Emittson','342-183-7563','derrywatson@gmail.com',900.00,'USA','Miami','550 Prize Street')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR115','Grove','Beats','932-846-1623','grovebeats@gmail.com',900.00,'USA','Lincoln','551 Hudson Street')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR116','Fulham','Spurs','458-193-1273','fulhamspurs@gmail.com',900.00,'USA','Charlotte','552 Russel Street')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR117','Vicky','Rodwood','237-957-2845','vickyrodwood@gmail.com',1000.00,'USA','Greenville','723 Pecos Circle')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR118','Neo','Aephason','585-875-9485','neoaephason@gmail.com',1000.00,'USA','Louisville','724 Unit Circle')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR119','Sue','Dodge','768-953-0183','suedodge@gmail.com',1000.00,'USA','Colombus','725 Yale Circle')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR120','Stanly','Prize','649-173-9212','stanlyprize@gmail.com',1000.00,'USA','San Diego','726 Los Circle')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR121','Henry','Wonders','563-058-4321','henrywonders@gmail.com',1000.00,'USA','Reno','727 Dallas Circle')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR122','Seize','Stones','409-857-6473','seizestones@gmail.com',1000.00,'USA','Minneapolis','728 Fayettville Circle')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR123','Wesley','Noah','943-123-5832','wesleynoah@gmail.com',1250.00,'USA','Tempe','729 Athens Circle')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR124','Tara','Song','658-586-0382','tarasong@gmail.com',1250.00,'USA','Fairfax','730 Treat Circle')");
            stmt.execute("INSERT INTO Customer VALUES ('CSR125','Joe','Larry','740-135-9584','joelarry@gmail.com',1250.00,'USA','Anderson','500 Heat Grove')");
            
           


            // Recipient Table
            stmt.execute("CREATE TABLE IF NOT EXISTS Recipient (" +
                        "RecipientId INT AUTO_INCREMENT PRIMARY KEY, " +
                        "First_Name VARCHAR(255), " +
                        "Last_Name VARCHAR(255), " +
                        "PhoneNumber VARCHAR(255), " +
                        "Email VARCHAR(255), " +
                        "Balance DOUBLE, " +
                        "Country VARCHAR(255), " +
                        "City VARCHAR(255), " +
                        "Address VARCHAR(255));");
                        // Insert into Recipient's table

            //set initial auto increment value
            stmt.execute("ALTER TABLE Recipient AUTO_INCREMENT = 1000");

         
            // Insert into Recipient's table without specifying RecipientId
            stmt.execute("INSERT INTO Recipient (First_Name, Last_Name, PhoneNumber, Email, Balance, Country, City, Address) VALUES " +
                        "('Rex', 'Cobbs', '574-937-0853', 'rexcobbs@gmail.com', 10.00, 'Ecuador', 'Ambato', '123 King Street'), " +
                        "('Henry', 'Gaither', '235-643-6434', 'henrygaither@gmail.com', 10.00, 'Ecuador', 'Ambato', '124 King Street'), " +
                        "('Prince', 'Stone', '694-696-3246', 'princestone@gmail.com', 10.00, 'Ecuador', 'Ambato', '125 King Street'), " +
                        "('Leslie', 'Song', '754-596-4575', 'lesliesong@gmail.com', 10.00, 'Ecuador', 'Ambato', '126 King Street'), " +
                        "('Maxwell', 'Gonzalez', '796-059-9563', 'maxwellgonzalez@gmail.com', 10.00, 'Ecuador', 'Ambato', '127 Prince Street'), " +
                        "('Harry', 'Williamson', '345-564-9482', 'harrywilliamson@gmail.com', 20.00, 'Ecuador', 'Ambato', '128 King Street'), " +
                        "('Ben', 'Dickson', '452-293-9683', 'bendickson@gmail.com', 20.00, 'Ecuador', 'Ambato', '129 King Street'), " +
                        "('Fred', 'Johnson', '239-069-4964', 'fredjohnson@gmail.com', 20.00, 'Ecuador', 'Quito', '130 Royal Street'), " +
                        "('Daniel', 'Timson', '904-486-4963', 'danieltimson@gmail.com', 20.00, 'Ecuador', 'Quito', '131 King Street'), " +
                        "('Moses', 'Hall', '694-923-1942', 'moseshall@gmail.com', 20.00, 'Ecuador', 'Quito', '342 School Circle'), " +
                        "('Marsh', 'Wilberforce', '683-495-0634', 'marshwilberforce@gmail.com', 20.00, 'Ecuador', 'Quito', '343 School Circle'), " +
                        "('Herbert', 'Livingstone', '234-695-0593', 'herbertlivingstone@gmail.com', 20.00, 'Ecuador', 'Quito', '344 School Circle'), " +
                        "('Bill', 'Patterson', '434-059-4329', 'billpatterson@gmail.com', 20.00, 'Ghana', 'Kumasi', '573 Screen Grove'), " +
                        "('William', 'Peterson', '406-596-4923', 'williampeterson@gmail.com', 20.00, 'Ghana', 'Kumasi', '574 Screen Grove'), " +
                        "('Catherine', 'Well', '679-458-0493', 'catherinewell@gmail.com', 15.00, 'Ghana', 'Kumasi', '575 Screen Grove'), " +
                        "('Lovert', 'Realson', '458-0795-0694', 'lovertrealson@gmail.com', 15.00, 'Ghana', 'Kumasi', '576 Screen Grove'), " +
                        "('Precious', 'Walker', '753-948-9583', 'preciouswalker@gmail.com', 15.00, 'Ghana', 'Kumasi', '577 Screen Grove'), " +
                        "('Emmanuel', 'Isaccs', '590-058-3133', 'emmanuelisaccs@gmail.com', 15.00, 'Ghana', 'Kumasi', '578 Screen Grove'), " +
                        "('Philip', 'Mensah', '586-964-8235', 'philipmensah@gmail.com', 15.00, 'Ghana', 'Kumasi', '579 Screen Grove'), " +
                        "('Jorge', 'Alvarez', '732-984-2834', 'jorgealvarez@gmail.com', 15.00, 'Ghana', 'Kumasi', '742 Hilton Parkway'), " +
                        "('William', 'Forge', '964-485-9684', 'williamforge@gmail.com', 15.00, 'Ghana', 'Kumasi', '743 Hilton Parkway'), " +
                        "('Hill', 'Forceful', '903-482-0482', 'hillforceful@gmail.com', 15.00, 'Ghana', 'Accra', '744 Hilton Parkway'), " +
                        "('Tremzol', 'King', '233-595-6964', 'tremzolking@gmail.com', 20.00, 'Ghana', 'Accra', '745 Hilton Parkway'), " +
                        "('Fierl', 'Haizel', '694-683-5066', 'fierlhaizel@gmail.com', 20.00, 'Ghana', 'Accra', '746 Hilton Parkway'), " +
                        "('Howard', 'Solid', '593-906-9683', 'howardsolid@gmail.com', 20.00, 'Ghana', 'Accra', '747 Hilton Parkway'), " +
                        "('Seth', 'Jones', '860-492-4955', 'sethjones@gmail.com', 20.00, 'Ghana', 'Accra', '748 Hilton Parkway');");

                        
            // Partner Table
            stmt.execute("CREATE TABLE IF NOT EXISTS Partner (" +
                         "PartnerId VARCHAR(255) PRIMARY KEY, " +
                         "Name VARCHAR(255), " +
                         "Type VARCHAR(255), " +
                         "Country VARCHAR(255), " +
                         "City VARCHAR(255), " +
                         "Address VARCHAR(255), " +
                         "FOREIGN KEY (PartnerId) REFERENCES User(UserId));");

            	
            // Insert into Partner's Table
            stmt.execute("INSERT INTO Partner VALUES ('PRT100','EcuadorPartner1','Money Transfer','Ecuador','Ambato','123 King Street')");
            stmt.execute("INSERT INTO Partner VALUES ('PRT101','EcuadorPartner2','Money Transfer','Ecuador','Quito','124 Royal Street')");
            stmt.execute("INSERT INTO Partner VALUES ('PRT102','GhanaPartner1','Money Transfer','Ghana','Kumasi','567 Hilton Parkway')");
            stmt.execute("INSERT INTO Partner VALUES ('PRT103','GhanaPartner2','Money Transfer','Ghana','Accra','843 Queen Circle')");


            
            
            
            // Remittance Table
            stmt.execute("CREATE TABLE IF NOT EXISTS Remittance (" +
                         "TransactionId INT AUTO_INCREMENT PRIMARY KEY, " +
                         "SenderId VARCHAR(255), " +
                         "RecipientId INT, " +
                         "PartnerId VARCHAR(255), " +
                         "AmountSent DOUBLE, " +
                         "AmountReceived DOUBLE, " +
                         "SourceCurrency VARCHAR(255), " +
                         "TargetCurrency VARCHAR(255), " +
                         "Status VARCHAR(255), " +
                         "CreatedAt DATETIME, " +
                         "UpdatedAt DATETIME, " +
                         "CancellationReason VARCHAR(255), " +
                         "ConfirmationDetails VARCHAR(255), " +
                         "FOREIGN KEY (SenderId) REFERENCES Customer(CustomerId), " +
                         "FOREIGN KEY (RecipientId) REFERENCES Recipient(RecipientId), " +
                         "FOREIGN KEY (PartnerId) REFERENCES Partner(PartnerId));");

        	//Start transactionID at 1000
            stmt.execute("ALTER TABLE Remittance AUTO_INCREMENT = 4514564");
            
            // ExchangeRate Table
            stmt.execute("CREATE TABLE IF NOT EXISTS ExchangeRate (" +
                         "ExchangeRateId INT AUTO_INCREMENT PRIMARY KEY, " +
                         "SourceCurrency VARCHAR(255), " +
                         "TargetCurrency VARCHAR(255), " +
                         "Rate DOUBLE, " +
                         "LastUpdated DATETIME);");

            // Additional tables can be added here following the same pattern
        }
    }
}
