package projectfiles.Dao;

import projectfiles.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {
    private UserDAO userDAO; // Dependency to handle User related database operations

    public CustomerDAOImpl() {
        this.userDAO = new UserDAOImpl(); // Initialize with concrete implementation
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        // Check if the user already exists using the provided UserDAO
        if (!userDAO.doesUserExist(customer.getId())) {
            // Since the user does not exist, add them to the User table first
            userDAO.addUser(customer);  // This handles the insertion into the 'users' table

            // SQL statement to insert the new customer into the 'customers' table
            String sql = "INSERT INTO Customer (CustomerId, Email, FirstName, LastName, PhoneNumber, Balance, Country, City, Address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (Connection conn = DatabaseCreds.getConnection();  // Ensure the connection is managed correctly
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, customer.getId());
                pstmt.setString(2, customer.getEmail());
                pstmt.setString(3, customer.getFirstName());
                pstmt.setString(4, customer.getLastName());
                pstmt.setString(5, customer.getPhoneNumber());
                pstmt.setDouble(6, customer.getBalance());
                pstmt.setString(7, customer.getCountry());
                pstmt.setString(8, customer.getCity());
                pstmt.setString(9, customer.getAddress());

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0) {
                    // No rows affected indicates that the insertion failed
                    throw new SQLException("Creating customer failed, no rows affected.");
                }
            } catch (SQLException e) {
                // Proper error logging and rethrowing exception
                System.err.println("SQL exception occurred while adding customer: " + e.getMessage());
                throw e;
            }
        } else {
            // Handle the case where the user already exists
            throw new SQLException("User already exists with ID: " + customer.getId());
        }
    }

    
    @Override
    public Customer getCustomerById(String customerId) throws SQLException {
        String sql = "SELECT CustomerId, Email, FirstName, LastName, PhoneNumber, Balance, Country, City, Address FROM Customer WHERE CustomerId = ?";  // Exclude password for security
        try (Connection conn = DatabaseCreds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                        rs.getString("CustomerId"),
                        "",
                        rs.getString("Email"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("PhoneNumber"),
                        rs.getDouble("Balance"),
                        rs.getString("Country"),
                        rs.getString("City"),
                        rs.getString("Address")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            throw e;
        }
        return null;
    }


    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        String sql = "UPDATE Customer SET Email = ?, FirstName = ?, LastName = ?, PhoneNumber = ?, Balance = ?, Country = ?, City = ?, Address = ? WHERE UserId = ?";
        try (Connection conn = DatabaseCreds.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getEmail());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setString(4, customer.getPhoneNumber());
            pstmt.setDouble(5, customer.getBalance());
            pstmt.setString(6, customer.getCountry());
            pstmt.setString(7, customer.getCity());
            pstmt.setString(8, customer.getAddress());
            pstmt.setString(9, customer.getId());
            pstmt.executeUpdate();
        }
    }
}
