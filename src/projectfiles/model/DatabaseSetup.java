package projectfiles.model;
import java.sql.*;


public class DatabaseSetup {
    private static final String URL = "jdbc:mysql://remitease.cr2esock8dpy.us-west-2.rds.amazonaws.com:3306/RemitEaseDev";
    private static final String USER = "admin";
    private static final String PASSWORD = "rEmitEase$";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTables(conn);
            System.out.println("Tables created successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void createTables(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            // User Table
            stmt.execute("CREATE TABLE User (" +
                         "UserId VARCHAR(255) PRIMARY KEY, " +
                         "Password VARCHAR(255) NOT NULL);");

            // Customer Table
            stmt.execute("CREATE TABLE Customer (" +
                         "CustomerId VARCHAR(255) PRIMARY KEY, " +
                         "Name VARCHAR(255), " +
                         "PhoneNumber VARCHAR(255), " +
                         "Email VARCHAR(255), " +
                         "Balance DOUBLE, " +
                         "Country VARCHAR(255), " +
                         "City VARCHAR(255), " +
                         "Address VARCHAR(255), " +
                         "FOREIGN KEY (CustomerId) REFERENCES User(UserId));");

            // Additional tables here...

            // Remittance Table
            stmt.execute("CREATE TABLE Remittance (" +
                         "TransactionId VARCHAR(255) PRIMARY KEY, " +
                         "SenderId VARCHAR(255), " +
                         "RecipientId VARCHAR(255), " +
                         "PartnerId VARCHAR(255), " +
                         "Amount DOUBLE, " +
                         "Currency VARCHAR(255), " +
                         "Status VARCHAR(255), " +
                         "CreatedAt DATETIME, " +
                         "UpdatedAt DATETIME, " +
                         "CancellationReason VARCHAR(255), " +
                         "ConfirmationDetails VARCHAR(255), " +
                         "FOREIGN KEY (SenderId) REFERENCES Customer(CustomerId), " +
                         "FOREIGN KEY (RecipientId) REFERENCES Recipient(RecipientId), " +
                         "FOREIGN KEY (PartnerId) REFERENCES Partner(PartnerId));");

            // Assume similar statements for other tables
        }
    }
}
