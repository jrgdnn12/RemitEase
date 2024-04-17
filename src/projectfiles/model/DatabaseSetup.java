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
            // User Table
            stmt.execute("CREATE TABLE IF NOT EXISTS User (" +
                         "UserId VARCHAR(255) PRIMARY KEY, " +
                         "Password VARCHAR(255) NOT NULL);");

            // Customer Table
            stmt.execute("CREATE TABLE IF NOT EXISTS Customer (" +
                         "CustomerId VARCHAR(255) PRIMARY KEY, " +
                         "Name VARCHAR(255), " +
                         "PhoneNumber VARCHAR(255), " +
                         "Email VARCHAR(255), " +
                         "Balance DOUBLE, " +
                         "Country VARCHAR(255), " +
                         "City VARCHAR(255), " +
                         "Address VARCHAR(255), " +
                         "FOREIGN KEY (CustomerId) REFERENCES User(UserId));");

            // Recipient Table
            stmt.execute("CREATE TABLE IF NOT EXISTS Recipient (" +
                         "RecipientId VARCHAR(255) PRIMARY KEY, " +
                         "Name VARCHAR(255), " +
                         "PhoneNumber VARCHAR(255), " +
                         "Email VARCHAR(255), " +
                         "Balance DOUBLE, " +
                         "Country VARCHAR(255), " +
                         "City VARCHAR(255), " +
                         "Address VARCHAR(255), " +
                         "FOREIGN KEY (RecipientId) REFERENCES User(UserId));");

            // Partner Table
            stmt.execute("CREATE TABLE IF NOT EXISTS Partner (" +
                         "PartnerId VARCHAR(255) PRIMARY KEY, " +
                         "Name VARCHAR(255), " +
                         "Type VARCHAR(255), " +
                         "Country VARCHAR(255), " +
                         "City VARCHAR(255), " +
                         "Address VARCHAR(255), " +
                         "FOREIGN KEY (PartnerId) REFERENCES User(UserId));");

            // Remittance Table
            stmt.execute("CREATE TABLE IF NOT EXISTS Remittance (" +
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
