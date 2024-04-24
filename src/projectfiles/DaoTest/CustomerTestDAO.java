package projectfiles.DaoTest;

import projectfiles.Dao.CustomerDAOImpl;
import projectfiles.model.Customer;

import java.sql.SQLException;

public class CustomerTestDAO {
    
    public static void main(String[] args) {
        // Create a test customer
        Customer testCustomer = new Customer(
            "testUserId123", // Assuming 'testUserId123' does not exist in your DB
            "password",
            "test@example.com",
            "Test",
            "User",
            "555-0123",
            100.50,
            "USA",
            "New York",
            "123 Test St."
        );

        // Instantiate the DAO implementation
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();

        // Test adding a customer
        try {
            System.out.println("Testing addCustomer...");
            customerDAO.addCustomer(testCustomer);
            System.out.println("Customer added successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to add customer: " + e.getMessage());
        }

        // Test retrieving a customer
        try {
            System.out.println("Testing getCustomerById...");
            Customer retrievedCustomer = customerDAO.getCustomerById("testUserId123");
            if (retrievedCustomer != null) {
                System.out.println("Retrieved Customer: " + retrievedCustomer.getFirstName() + " " + retrievedCustomer.getLastName());
            } else {
                System.out.println("No customer found with ID testUserId123.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve customer: " + e.getMessage());
        }

        // Test updating a customer
        try {
            System.out.println("Testing updateCustomer...");
            testCustomer.setCity("Brooklyn"); // Change a detail
            customerDAO.updateCustomer(testCustomer);
            System.out.println("Customer updated successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to update customer: " + e.getMessage());
        }
    }
}
